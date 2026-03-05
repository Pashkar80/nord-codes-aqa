package com.aqa;

import static com.aqa.config.TestConfig.BASE_URL;
import static com.aqa.config.TestConfig.ENDPOINT;

public class Service {

  public String getLoginEndpoint() {
    return BASE_URL + ENDPOINT;
  }
}