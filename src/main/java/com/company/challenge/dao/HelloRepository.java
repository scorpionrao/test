package com.company.challenge.dao;

import com.company.challenge.model.HelloModel;
import com.company.challenge.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloRepository {

    private final AppProperties appProperties;

    @Autowired
    public HelloRepository(AppProperties appProperties){
        this.appProperties = appProperties;
    }

    public HelloModel getGreeting() {
        return new HelloModel(appProperties.getWelcomeText());
    }
}
