package com.aqa.utils.stubs;

import static com.aqa.config.StubsConfig.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;

public class ActionStubs {

  private ActionStubs() {}

  public static void stubActionSuccess(WireMockServer server, String token) {
    server.stubFor(createBaseActionStub(token)
        .willReturn(createBaseResponse(STATUS_OK)
            .withBody("{\"result\": \"OK\"}")));
  }

  private static MappingBuilder createBaseActionStub(String token) {
    return post(urlEqualTo(DO_ACTION_URL))
        .withHeader(CONTENT_TYPE_HEADER, containing(CONTENT_TYPE_VALUE))
        .withHeader(ACCEPT_HEADER, containing(ACCEPT_VALUE))
        .withRequestBody(containing(TOKEN_PARAM + token));
  }

  private static ResponseDefinitionBuilder createBaseResponse(int statusCode) {
    return aResponse()
        .withStatus(statusCode)
        .withHeader(CONTENT_TYPE_HEADER, RESPONSE_CONTENT_TYPE);
  }
}