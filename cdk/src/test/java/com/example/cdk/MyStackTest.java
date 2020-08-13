package com.example.cdk;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import software.amazon.awscdk.core.App;

public class MyStackTest {
  private static final ObjectMapper JSON =
      new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

  @Test
  public void testStack() throws IOException {
    var app = new App();
    var stack = new MyStack(app, "test");

    List<String> actual =
        JSON.valueToTree(app.synth().getStackArtifact(stack.getArtifactId()).getTemplate())
            .path("Resources").findValues("Type").stream()
            .map(JsonNode::textValue)
            .collect(Collectors.toList());
    assertTrue(
        actual.containsAll(
            List.of(
                "AWS::IAM::Role",
                "AWS::Lambda::Function",
                "AWS::ApiGatewayV2::Api",
                "AWS::Lambda::Permission",
                "AWS::ApiGatewayV2::Integration",
                "AWS::ApiGatewayV2::Route",
                "AWS::ApiGatewayV2::Stage")));
  }
}
