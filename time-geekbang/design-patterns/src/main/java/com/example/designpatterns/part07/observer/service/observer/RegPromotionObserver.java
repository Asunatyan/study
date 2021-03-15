package com.example.designpatterns.part07.observer.service.observer;

import com.example.designpatterns.part07.observer.eventBus.Subscribe;


public class RegPromotionObserver {//Promotion 促销,活动
  private PromotionService promotionService; // 依赖注入

  @Subscribe
  public void handleRegSuccess(Long userId) {
    promotionService.issueNewUserExperienceCash(userId);
  }
}

