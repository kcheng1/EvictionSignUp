package com.zyu.expulsion.submit.form.controller;

import com.zyu.expulsion.submit.form.dto.FormSubmitRequest;
import com.zyu.expulsion.submit.form.service.SignUpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/form/submit")
public class FormSubmitController {

    private Logger logger = LogManager.getLogger(FormSubmitController.class);
    @Autowired
    private SignUpService signUpService;

    @PostMapping()
    public ResponseEntity<Void> submitForm(@RequestBody FormSubmitRequest request) {
        try {
            signUpService.save(request);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error submitting form", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
