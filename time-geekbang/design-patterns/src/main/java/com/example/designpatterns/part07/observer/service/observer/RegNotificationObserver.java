package com.example.designpatterns.part07.observer.service.observer;

import com.example.designpatterns.part07.observer.eventBus.Subscribe;

/**
 * Description:
 * date: 2021/3/15 10:36
 *
 * @author dqk
 */
public class RegNotificationObserver {
  private NotificationService notificationService;

  @Subscribe
  public void handleRegSuccess(Long userId) {
    notificationService.sendInboxMessage(userId, "...");
  }
}
