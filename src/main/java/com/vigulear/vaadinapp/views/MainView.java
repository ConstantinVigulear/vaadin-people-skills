package com.vigulear.vaadinapp.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * @author Constantin Vigulear
 */
@Route(value = "", layout = MainLayout.class) // map view to the root
class MainView extends VerticalLayout {

  MainView() {

  }
}
