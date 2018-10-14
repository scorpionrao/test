package com.company.challenge.service;

import com.company.challenge.dao.HelloRepository;
import com.company.challenge.model.HelloModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class HelloServiceTests {

    private HelloService helloService;

    @Mock
    private HelloRepository helloRepository;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        helloService = new HelloService(helloRepository);
    }

    @Test
    public void testHello() {

        HelloModel helloModel = new HelloModel("Greetings");
        Mockito.when(helloRepository.getGreeting()).thenReturn(helloModel);

        HelloModel outputHelloModel = helloService.getGreeting();

        Assert.assertNotNull(outputHelloModel);
        Assert.assertTrue(helloModel.getWelcomeText().equals(outputHelloModel.getWelcomeText()));

    }

}


