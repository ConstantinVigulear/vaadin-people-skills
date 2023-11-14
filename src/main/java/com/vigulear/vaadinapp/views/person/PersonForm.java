package com.vigulear.vaadinapp.views.person;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.shared.Registration;
import com.vigulear.vaadinapp.data.entity.Person;
import com.vigulear.vaadinapp.views.skill.SkillView;

/**
 * @author Constantin Vigulear
 */
public class PersonForm extends FormLayout {
  Binder<Person> binder = new BeanValidationBinder<>(Person.class);
  TextField firstName = new TextField("First name");
  TextField lastName = new TextField("Last name");
  EmailField email = new EmailField("Email");
  TextField totalCost = new TextField("Total cost");
  Button skills = new Button("Skills");

  Button save = new Button("Save");
  Button delete = new Button("Delete");
  Button cancel = new Button("Cancel");
  private Person person;

  public PersonForm() {
    addClassName("contact-form");
    binder.bindInstanceFields(this);
    totalCost.setReadOnly(true);

    add(firstName, lastName, email, totalCost, skills, createButtonsLayout());
  }

  public void setPerson(Person person) {
    this.person = person;
    binder.readBean(person);
  }

  public void prepareSkillsButton() {
    RouterLink link = new RouterLink("", SkillView.class);
    link.setHighlightCondition(HighlightConditions.sameLocation());

    skills.addClickListener(
        event ->
            getUI().ifPresent(ui -> ui.navigate(link.getHref() + "/" + person.getId())));
  }

  private Component createButtonsLayout() {
    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
    cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

    save.addClickListener(event -> validateAndSave());
    delete.addClickListener(event -> fireEvent(new DeleteEvent(this, person)));
    cancel.addClickListener(event -> fireEvent(new CloseEvent(this)));

    save.addClickShortcut(Key.ENTER);
    cancel.addClickShortcut(Key.ESCAPE);

    return new HorizontalLayout(save, delete, cancel);
  }

  private void validateAndSave() {
    try {
      binder.writeBean(person);
      fireEvent(new SaveEvent(this, person));
    } catch (ValidationException exception) {
      Notification.show(exception.getMessage(), 1500, Notification.Position.MIDDLE);
    }
  }

  // Events
  public abstract static class PersonFormEvent extends ComponentEvent<PersonForm> {
    private final Person contact;

    protected PersonFormEvent(PersonForm source, Person contact) {
      super(source, false);
      this.contact = contact;
    }

    public Person getPerson() {
      return contact;
    }
  }

  public static class SaveEvent extends PersonFormEvent {
    SaveEvent(PersonForm source, Person contact) {
      super(source, contact);
    }
  }

  public static class DeleteEvent extends PersonFormEvent {
    DeleteEvent(PersonForm source, Person contact) {
      super(source, contact);
    }
  }

  public static class CloseEvent extends PersonFormEvent {
    CloseEvent(PersonForm source) {
      super(source, null);
    }
  }

  public Registration addDeleteListener(ComponentEventListener<DeleteEvent> listener) {
    return addListener(DeleteEvent.class, listener);
  }

  public Registration addSaveListener(ComponentEventListener<SaveEvent> listener) {
    return addListener(SaveEvent.class, listener);
  }

  public Registration addCloseListener(ComponentEventListener<CloseEvent> listener) {
    return addListener(CloseEvent.class, listener);
  }
}
