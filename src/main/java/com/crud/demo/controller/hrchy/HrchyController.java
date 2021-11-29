package com.crud.demo.controller.hrchy;

import com.crud.demo.model.hrchy.Hrchy;
import com.crud.demo.model.response.ResponseError;
import com.crud.demo.service.HrchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/hrchys")
public class HrchyController {

    @Autowired
    private HrchyService hrchyService;

    @PostMapping
    public ResponseEntity<?> createHrchy(@Valid @RequestBody Hrchy hrchy, BindingResult result){

        hrchyService.saveHrchy(hrchy);

        return new ResponseEntity<>("", HttpStatus.OK);

    }

}
