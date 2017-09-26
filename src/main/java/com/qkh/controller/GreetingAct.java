package com.qkh.controller;

import com.qkh.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingAct {

    @Autowired
    private GreetingService service;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ResponseEntity greeting()
    {
        return new ResponseEntity(service.greeting(), HttpStatus.OK);
    }

}
