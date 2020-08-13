package com.example.cdk;

import software.amazon.awscdk.core.App;

public class MyApp {
  public static void main(final String[] args) {
    var app = new App();

    new MyStack(app, "MyStack");

    app.synth();
  }
}
