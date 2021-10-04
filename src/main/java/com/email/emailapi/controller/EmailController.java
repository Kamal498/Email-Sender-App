package com.email.emailapi.controller;


import com.email.emailapi.model.EmailRequest;
import com.email.emailapi.service.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmailController {


    @Autowired
    private SendEmail service;

    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){
        
        Boolean result = this.service.sendEmailToMultiple(emailRequest.getMessage(), emailRequest.getSubject(), emailRequest.getTo());

        if(result){
            return ResponseEntity.status(HttpStatus.OK).body("Message sent successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Oops, here was some error :(");
        }
    }

}
