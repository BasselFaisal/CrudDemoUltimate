package com.crud.demo.controller.hrchy;

import com.crud.demo.Constants;
import com.crud.demo.model.hrchy.Hrchy;
import com.crud.demo.model.response.Response;
import com.crud.demo.model.response.ResponseError;
import com.crud.demo.model.user.User;
import com.crud.demo.service.HrchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hrchys")
public class HrchyController {

    @Autowired
    private HrchyService hrchyService;


    @GetMapping
    public ResponseEntity<?> getAllHrchys(){

        Response response = new Response();

        try {
            List<Hrchy> hrchies = hrchyService.findAll();
            response.setData(hrchies);
            response.setSuccess(true);

            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            response.addErrorMsgToResponse(e.getMessage());
            response.setSuccess(false);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHrchy(@PathVariable("id") int id) {

        Response response = new Response();
        try {
            Hrchy hrchy = hrchyService.findById(id);

            if (hrchy != null) {
                response.setSuccess(true);
                response.setData(hrchy);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setSuccess(false);
                response.addErrorMsgToResponse(Constants.HRCHY_NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> createHrchy(@Validated @RequestBody Hrchy hrchy, BindingResult result){

        Response response = new Response();

        if(result.hasErrors()){
            Response errorResponse = new Response();
            response.setSuccess(false);
            result.getAllErrors().forEach(error -> errorResponse.addErrorMsgToResponse(error.getDefaultMessage()));
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }


        response = hrchyService.saveHrchy(hrchy);

        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Validated @RequestBody Hrchy hrchy, BindingResult result){

        Response response = new Response();

        if(result.hasErrors()){
            Response errorResponse = new Response();
            response.setSuccess(false);
            result.getAllErrors().forEach(error -> errorResponse.addErrorMsgToResponse(error.getDefaultMessage()));
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        response = hrchyService.UpdateHrchy(hrchy);

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
            Hrchy hrchy = hrchyService.DeleteById(id);

            if (hrchy != null) {
                response.setSuccess(true);
                response.setData(hrchy);
                return new ResponseEntity<>(hrchy, HttpStatus.OK);
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
