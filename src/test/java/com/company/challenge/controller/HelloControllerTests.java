package com.company.challenge.controller;

import com.company.challenge.model.HelloModel;
import com.company.challenge.model.RestApiResult;
import com.company.challenge.service.HelloService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class HelloControllerTests {

    private HelloController helloController;

    @Mock
    private HelloService helloService;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        helloController = new HelloController(helloService);
    }

    @Test
    public void testHello() {

        HelloModel helloModel = new HelloModel("Greetings");
        Mockito.when(helloService.getGreeting()).thenReturn(helloModel);
        ResponseEntity<RestApiResult> restApiResponse = helloController.getGreeting();

        Assert.assertNotNull(restApiResponse);

        Assert.assertEquals(HttpStatus.OK, restApiResponse.getStatusCode());

        RestApiResult restApiResult = restApiResponse.getBody();
        Assert.assertNotNull(restApiResult);

        HelloModel model = (HelloModel) restApiResult.getResult();
        Assert.assertTrue("Greetings".equals(model.getWelcomeText()));

    }

}

