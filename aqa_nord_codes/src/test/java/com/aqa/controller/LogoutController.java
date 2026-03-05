package com.aqa.controller;

import static com.aqa.config.TestConfig.LOGOUT;

import com.aqa.builder.RequestBuilder;
import com.aqa.model.AppResponse;
import com.aqa.Service;
import io.restassured.specification.RequestSpecification;

public class LogoutController {

  private Service service;
  private RequestSpecification requestSpec;

  public LogoutController(Service service, RequestSpecification requestSpec) {
    this.service = service;
    this.requestSpec = requestSpec;
  }

  public void sendLogoutRequest(String token) {
    new RequestBuilder()
        .withToken(token)
        .withAction(LOGOUT)
        .build()
        .post(service.getLoginEndpoint());
  }

  public AppResponse sendLogoutRequestAndGetResponse(String token) {
    return new RequestBuilder()
        .withToken(token)
        .withAction(LOGOUT)
        .build()
        .post(service.getLoginEndpoint())
        .then()
        .extract()
        .as(AppResponse.class);
  }
}