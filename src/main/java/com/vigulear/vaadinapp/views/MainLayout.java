package com.vigulear.vaadinapp.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vigulear.vaadinapp.views.person.PeopleView;
import com.vigulear.vaadinapp.views.skill.SkillView;

/**
 * @author Constantin Vigulear
 */
public class MainLayout extends AppLayout {
  public MainLayout() {
    createHeader();
    createDrawer();
  }

  private void createHeader() {
    H1 logo = new H1("People-Skills App");
    logo.addClassNames("text-l", "m-m");

    HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

    header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
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
