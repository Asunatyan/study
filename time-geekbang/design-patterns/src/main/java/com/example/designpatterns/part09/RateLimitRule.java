package com.example.designpatterns.part09;

public class RateLimitRule {
  public RateLimitRule(RuleConfig ruleConfig) {
    //...

  }

  public ApiLimit getLimit(String appId, String api) {
    //...
    return new ApiLimit();
  }
}