package com.movies.movies.modules.twilio.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwilioController {

    @Value("${twilio.ssid}")
    private String ssid;

    @Value("${twilio.token}")
    private String token;

    @Value("${twilio.phone}")
    private String phoneNumber;

    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS(){
        Twilio.init(ssid, token);

        Message.creator(new PhoneNumber("+527773760183"), new PhoneNumber(phoneNumber),"Saludos de mí").create();
        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
