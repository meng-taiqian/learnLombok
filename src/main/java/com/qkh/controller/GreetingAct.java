package com.qkh.controller;

import com.qkh.entity.City;
import com.qkh.service.GreetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "欢迎Controller")
public class GreetingAct {

    @Autowired
    private GreetingService service;

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    @ApiOperation(value = "打招呼")
    public ResponseEntity greeting(City city)
    {
        return new ResponseEntity(service.greeting(), HttpStatus.OK);
    }

}
