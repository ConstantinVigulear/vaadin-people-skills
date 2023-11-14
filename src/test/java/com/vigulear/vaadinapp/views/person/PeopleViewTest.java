package com.vigulear.vaadinapp.views.person;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletService;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import com.vigulear.vaadinapp.data.entity.Person;
import com.vigulear.vaadinapp.data.exception_handling.CustomErrorHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Constantin Vigulear
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PeopleViewTest {

  @Qualifier("peopleView")
  @Autowired
  private PeopleView view;


  @BeforeEach
  void setUp() {

  }

  @Test
  public void formShownWhenPersonSelected() {

    Grid<Person> grid = view.personGrid;
    Person firstPerson = getFirstItem(grid);

    PersonForm form = view.personForm;

    assertFalse(form.isVisible());
    grid.asSingleSelect().setValue(firstPerson);

    assertTrue(form.isVisible());
    assertEquals(firstPerson.getFirstName(), form.firstName.getValue());
  }

  private Person getFirstItem(Grid<Person> grid) {
    return ((ListDataProvider<Person>) grid.getDataProvider()).getItems().iterator().next();
  }
}
