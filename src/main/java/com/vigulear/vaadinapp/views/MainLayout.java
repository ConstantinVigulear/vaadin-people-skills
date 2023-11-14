package com.vigulear.vaadinapp.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vigulear.vaadinapp.security.SecurityService;
import com.vigulear.vaadinapp.views.person.PeopleView;
import com.vigulear.vaadinapp.views.skill.SkillView;

/**
 * @author Constantin Vigulear
 */
public class MainLayout extends AppLayout {

  private final SecurityService securityService;

  public MainLayout(SecurityService securityService) {
    this.securityService = securityService;
    createHeader();
    createDrawer();
  }

  private void createHeader() {
    H1 logo = new H1("People-Skills App");
    logo.addClassNames("text-l", "m-m");

    String user = securityService.getAuthenticatedUser().getUsername();
    Button logout = new Button("Log out " + user, e -> securityService.logout());

    HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);

    header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

    // to make the logo take up all the extra space in the layout. This can push the logout button
    // to the far right.
    header.expand(logo);
    header.setSizeFull();
    header.addClassNames("py-0", "px-m");

    addToNavbar(header);
  }

  private void createDrawer() {
    RouterLink peopleView = new RouterLink("People", PeopleView.class);
    RouterLink skillView = new RouterLink("Skills", SkillView.class);

    peopleView.setHighlightCondition(HighlightConditions.sameLocation());
    skillView.setHighlightCondition(HighlightConditions.sameLocation());

    addToDrawer(new VerticalLayout(peopleView));
    addToDrawer(new VerticalLayout(skillView));
  }
}
