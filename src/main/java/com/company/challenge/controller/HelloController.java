package com.company.challenge.controller;

import com.company.challenge.model.RestApiResult;
import com.company.challenge.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/hello"}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public ResponseEntity<RestApiResult> getGreeting() {
        RestApiResult restApiResult = new RestApiResult(null, helloService.getGreeting());
        return new ResponseEntity<>(restApiResult, HttpStatus.OK);
    }
}
