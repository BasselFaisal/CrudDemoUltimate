package com.crud.demo.controller.user;

import com.crud.demo.Constants;
import com.crud.demo.model.response.Response;
import com.crud.demo.model.user.User;
import com.crud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){

        Response response = new Response();

        try {
            List<User> users = userService.findAll();
            response.setData(users);
            response.setSuccess(true);

            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            response.addErrorMsgToResponse(e.getMessage());
            response.setSuccess(false);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") int id) {

        Response response = new Response();
        try {
            User user = userService.findById(id);

            if (user != null) {
                response.setSuccess(true);
                response.setData(user);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setSuccess(false);
                response.addErrorMsgToResponse(Constants.USER_NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Validated @RequestBody User user, BindingResult result){

        Response response = new Response();

        if(result.hasErrors()){
            Response errorResponse = new Response();
            response.setSuccess(false);
            result.getAllErrors().forEach(error -> errorResponse.addErrorMsgToResponse(error.getDefaultMessage()));
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        if(userService.checkIfExistByCode(user.getUserCode())){
            response.setSuccess(false);
            response.addErrorMsgToResponse(Constants.EXIST_BY_CODE);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        response = userService.saveUser(user);

        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Validated @RequestBody User user, BindingResult result){

        Response response = new Response();

        if(result.hasErrors()){
            Response errorResponse = new Response();
            response.setSuccess(false);
            result.getAllErrors().forEach(error -> errorResponse.addErrorMsgToResponse(error.getDefaultMessage()));
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        response = userService.UpdateUser(user);

        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {

        Response response = new Response();
        try {
            User user = userService.DeleteById(id);

            if (user != null) {
                response.setSuccess(true);
                response.setData(user);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                response.setSuccess(false);
                response.addErrorMsgToResponse(Constants.USER_NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
