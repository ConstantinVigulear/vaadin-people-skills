package com.vigulear.vaadinapp.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vigulear.vaadinapp.data.exception_handling.CustomErrorHandler;
import jakarta.annotation.security.PermitAll;

/**
 * @author Constantin Vigulear
 */
@PermitAll
@Route(value = "", layout = MainLayout.class) // map view to the root
class MainView extends VerticalLayout {

  MainView() {
    VaadinSession.getCurrent().setErrorHandler(new CustomErrorHandler());
  }
}
