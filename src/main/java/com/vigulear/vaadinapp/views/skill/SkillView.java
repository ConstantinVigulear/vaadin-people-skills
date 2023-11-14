package com.vigulear.vaadinapp.views.skill;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializableComparator;
import com.vaadin.flow.router.*;
import com.vigulear.vaadinapp.data.entity.Skill;
import com.vigulear.vaadinapp.data.service.PersonSkillService;
import com.vigulear.vaadinapp.views.MainLayout;
import jakarta.annotation.security.PermitAll;

/**
 * @author Constantin Vigulear
 */
@PermitAll
@PageTitle("Skills | Vaadin App")
@Route(value = "skills", layout = MainLayout.class)
public class SkillView extends VerticalLayout implements HasUrlParameter<String> {
  Grid<Skill> skillGrid = new Grid<>(Skill.class);
  TextField filterText = new TextField();
  private final PersonSkillService service;
  SkillForm skillForm;
  Long personId = 0L;

  public SkillView(PersonSkillService service) {
    this.service = service;
    addClassName("list-view");
    setSizeFull();

    configureSkillGrid();
    configureSkillForm();

    add(getToolBar(), getContent());
    closeEditor();
  }

  private void configureSkillGrid() {
    skillGrid.addClassName("skill-grid");
    skillGrid.setSizeFull();
    skillGrid.setColumns("name");
    skillGrid.addColumn(skill -> skill.getDomain().getName()).setHeader("Domain").setSortable(true);
    skillGrid
        .addColumn(skill -> skill.getLevel().getName())
        .setHeader("Level")
        .setComparator(getLevelComparator());
    skillGrid.getColumns().forEach(column -> column.setAutoWidth(true));
    skillGrid.addColumn(Skill::getSkillPrice).setHeader("Price").setSortable(true);

    skillGrid.asSingleSelect().addValueChangeListener(event -> editSkill(event.getValue()));
  }

  private void configureSkillForm() {
    skillForm = new SkillForm(service.findAllDomains(), service.findAllLevels());
    skillForm.setWidth("25em");

    skillForm.addListener(SkillForm.SaveEvent.class, this::saveSkill);
    skillForm.addListener(SkillForm.DeleteEvent.class, this::deleteSkill);
    skillForm.addListener(SkillForm.CloseEvent.class, e -> closeEditor());
  }

  private void addSkill() {
    skillGrid.asSingleSelect().clear();
    skillForm.name.setReadOnly(false);
    skillForm.domain.setReadOnly(false);
    skillForm.level.setReadOnly(false);
    editSkill(new Skill());
  }

  private void editSkill(Skill skill) {
    if (skill == null) {
      closeEditor();
    } else {
      skillForm.setSkill(skill);
      skillForm.preparePeopleButton();
      skillForm.setVisible(true);
      skillForm.people.setVisible(skill.getId() != null);
      skillForm.delete.setVisible(skill.getId() != null);
    }
  }

  private void saveSkill(SkillForm.SkillFormEvent event) {
    if (personId == 0) {
      service.saveSkill(event.getSkill());
    } else {
      service.addSkillToPerson(event.getSkill(), personId);
    }

    updateList();
    closeEditor();
  }

  private void deleteSkill(SkillForm.SkillFormEvent event) {
    if (personId == 0) {
      service.deleteSkill(event.getSkill());
    } else {
      service.removeSkillFromPerson(event.getSkill().getId(), personId);
    }
    updateList();
    closeEditor();
  }

  private Component getToolBar() {
    filterText.setPlaceholder("Filter by name...");
    filterText.setClearButtonVisible(true);
    filterText.setValueChangeMode(ValueChangeMode.LAZY);
    filterText.addValueChangeListener(event -> updateList());

    Button addSkillButton = new Button("Add skill");
    addSkillButton.addClickListener(event -> addSkill());

    HorizontalLayout toolbar = new HorizontalLayout(filterText, addSkillButton);
    toolbar.addClassName("toolbar");

    return toolbar;
  }

  private Component getContent() {
    HorizontalLayout content = new HorizontalLayout(skillGrid, skillForm);
    content.setFlexGrow(2, skillGrid);
    content.setFlexGrow(1, skillForm);
    content.addClassName("content");
    content.setSizeFull();

    return content;
  }

  private void closeEditor() {
    skillForm.setSkill(null);
    skillForm.setVisible(false);
    skillGrid.select(null);
    removeClassName("editing");
  }

  private void updateList() {
    if (personId == 0) {
      skillGrid.setItems(service.findAllSkills(filterText.getValue()));
    } else {
      skillGrid.setItems(service.findPersonWithSkillsById(personId).getSkills());
    }
  }

  private static SerializableComparator<Skill> getLevelComparator() {
    return (o1, o2) -> o1.getLevel().getLevelValue().compareTo(o2.getLevel().getLevelValue());
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {
    if (s != null) {
      personId = Long.parseLong(s);
      skillForm.name.setReadOnly(true);
      skillForm.domain.setReadOnly(true);
      skillForm.level.setReadOnly(true);
    } else {
      personId = 0L;
    }
    updateList();
  }
}
