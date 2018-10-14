package com.company.challenge.service;

import com.company.challenge.model.HelloModel;
import com.company.challenge.dao.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final HelloRepository helloRepository;

    @Autowired
    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public HelloModel getGreeting() {
        return this.helloRepository.getGreeting();
    }
}
