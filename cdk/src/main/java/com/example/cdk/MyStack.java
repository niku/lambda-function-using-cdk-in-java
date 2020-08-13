package com.example.cdk;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;

public class MyStack extends Stack {
  public MyStack(final Construct scope, final String id) {
    this(scope, id, null);
  }

  public MyStack(final Construct scope, final String id, final StackProps props) {
    super(scope, id, props);

    new MyConstruct(this, "Service");
  }
}
