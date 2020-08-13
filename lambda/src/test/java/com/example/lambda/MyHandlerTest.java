package com.example.lambda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MyHandlerTest {
  @Test
  void testHandleRequest() {
    var event = new APIGatewayV2ProxyRequestEvent();
    var context =
        new Context() {

          @Override
          public String getAwsRequestId() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public String getLogGroupName() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public String getLogStreamName() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public String getFunctionName() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public String getFunctionVersion() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public String getInvokedFunctionArn() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public CognitoIdentity getIdentity() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public ClientContext getClientContext() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public int getRemainingTimeInMillis() {
            // TODO Auto-generated method stub
            return 0;
          }

          @Override
          public int getMemoryLimitInMB() {
            // TODO Auto-generated method stub
            return 0;
          }

          @Override
          public LambdaLogger getLogger() {
            return new LambdaLogger() {

              @Override
              public void log(String message) {
                System.out.println(message);
              }

              @Override
              public void log(byte[] message) {
                System.out.println(Arrays.toString(message));
              }
            };
          }
        };

    var handler = new MyHandler();
    var result = handler.handleRequest(event, context);
    assertTrue(result.getBody().contains("200 OK"));
  }
}
