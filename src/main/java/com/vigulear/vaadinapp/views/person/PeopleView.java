package com.vigulear.vaadinapp.views.person;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.*;
import com.vigulear.vaadinapp.data.entity.Person;
import com.vigulear.vaadinapp.data.service.PersonSkillService;
import com.vigulear.vaadinapp.views.MainLayout;

/**
 * @author Constantin Vigulear
 */
@PageTitle("People | Vaadin App")
@Route(value = "people", layout = MainLayout.class)
public class PeopleView extends VerticalLayout implements HasUrlParameter<String> {
  private final PersonSkillService service;
  Grid<Person> personGrid = new Grid<>(Person.class);
  TextField filterText = new TextField();
  PersonForm personForm;

  Long skillId = 0L;

  public PeopleView(PersonSkillService service) {
    this.service = service;
    addClassName("list-view");
    setSizeFull(); // use all browser windows space, not just components

    configurePersonGrid();
    configurePersonForm();

    add(getToolbar(), getContent());

    updateList();
    closeEditor();
  }

  private void closeEditor() {
    personForm.setPerson(null);
    personForm.setVisible(false);
    personGrid.select(null);
    removeClassName("editing");
  }

  private void configurePersonForm() {
    personForm = new PersonForm();
    personForm.setWidth("25em");

    personForm.addSaveListener(this::savePerson);
    personForm.addDeleteListener(this::deletePerson);
    personForm.addCloseListener(event -> closeEditor());
  }

  private void configurePersonGrid() {
    personGrid.addClassName("person-grid");
    personGrid.setSizeFull();
    personGrid.setColumns("firstName", "lastName", "email");
    personGrid.getColumns().forEach(column -> column.setAutoWidth(true));

    personGrid.asSingleSelect().addValueChangeListener(event -> editPerson(event.getValue()));
  }

  private Component getToolbar() {
    filterText.setPlaceholder("Filter by name...");
    filterText.setClearButtonVisible(true);
    filterText.setValueChangeMode(ValueChangeMode.LAZY);
    filterText.addValueChangeListener(event -> updateList());

    Button addPersonButton = new Button("Add person");
    addPersonButton.addClickListener(event -> addPerson());

    HorizontalLayout toolbar = new HorizontalLayout(filterText, addPersonButton);
    toolbar.addClassName("toolbar");

    return toolbar;
  }

  private void addPerson() {
    personGrid.asSingleSelect().clear();
    personForm.firstName.setReadOnly(false);
    personForm.lastName.setReadOnly(false);
    personForm.email.setReadOnly(false);

    editPerson(new Person());
  }

  private void editPerson(Person person) {
    if (person == null) {
      closeEditor();
    } else {
      personForm.setPerson(person);
      personForm.prepareSkillsButton();
      personForm.setVisible(true);
      personForm.skills.setVisible(person.getId() != null);
      personForm.delete.setVisible(person.getId() != null);
    }
  }

  private void savePerson(PersonForm.SaveEvent event) {
    if (skillId == 0) {
      service.savePerson(event.getPerson());
    } else {
      service.addPersonToSkill(event.getPerson(), skillId);
    }
    updateList();
    closeEditor();
  }

  private void deletePerson(PersonForm.DeleteEvent event) {
    if (skillId == 0) {
      service.deletePerson(event.getPerson());
    } else {
      service.removePersonFromSkill(event.getPerson().getId(), skillId);
    }
    updateList();
    closeEditor();
  }

  private Component getContent() {
    HorizontalLayout content = new HorizontalLayout(personGrid, personForm);
    content.setFlexGrow(2, personGrid);
    content.setFlexGrow(1, personForm);
    content.addClassName("content");
    content.setSizeFull();

    return content;
  }

  private void updateList() {
    if (skillId == 0) {
      personGrid.setItems(service.findAllPeople(filterText.getValue()));
    } else {
      personGrid.setItems(service.findSkillsWithPeopleById(skillId).getPersons());
    }
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {
    if (s != null) {
      skillId = Long.parseLong(s);
      personForm.firstName.setReadOnly(true);
      personForm.lastName.setReadOnly(true);
      personForm.email.setReadOnly(true);
    } else {
      skillId = 0L;
    }
    updateList();
  }
}
