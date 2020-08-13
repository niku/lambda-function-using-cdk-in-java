package com.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHandler
    implements RequestHandler<APIGatewayV2ProxyRequestEvent, APIGatewayV2ProxyResponseEvent> {
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Override
  public APIGatewayV2ProxyResponseEvent handleRequest(
      final APIGatewayV2ProxyRequestEvent input, final Context context) {
    var logger = context.getLogger();
    logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
    logger.log("CONTEXT: " + gson.toJson(context));
    logger.log("EVENT: " + gson.toJson(input));
    logger.log("EVENT TYPE: " + input.getClass().toString());

    var response = new APIGatewayV2ProxyResponseEvent();
    response.setIsBase64Encoded(false);
    response.setStatusCode(200);
    response.setBody("200 OK");

    return response;
  }
}
