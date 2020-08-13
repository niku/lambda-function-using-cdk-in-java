package com.example.cdk;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.services.apigatewayv2.HttpApi;
import software.amazon.awscdk.services.apigatewayv2.LambdaProxyIntegration;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;

public class MyConstruct extends Construct {

  public MyConstruct(final Construct scope, final String id) {
    super(scope, id);

    HttpApi.Builder.create(this, "MyHttpApi")
        .defaultIntegration(
            LambdaProxyIntegration.Builder.create()
                .handler(
                    Function.Builder.create(this, "MyFunction")
                        .runtime(Runtime.JAVA_11)
                        .code(Code.fromAsset("../lambda/build/distributions/lambda.zip"))
                        .handler("com.example.lambda.MyHandler::handleRequest")
                        .build())
                .build())
        .build();
  }
}
