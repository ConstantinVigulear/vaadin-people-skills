package com.vigulear.vaadinapp.data.exception_handling;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.server.ErrorEvent;
import com.vaadin.flow.server.ErrorHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Constantin Vigulear
 */
public class CustomErrorHandler implements ErrorHandler {

  private static final Logger logger = LoggerFactory.getLogger(CustomErrorHandler.class);

  @Override
  public void error(ErrorEvent errorEvent) {
    String errorMessage = errorEvent.getThrowable().getMessage();

    logger.error(errorMessage, errorEvent.getThrowable());

    if (UI.getCurrent() != null) {
      UI.getCurrent()
          .access(
              () ->
                  Notification.show(
                      errorEvent.getThrowable().getMessage(), 1500, Notification.Position.MIDDLE));
    }
  }
}
