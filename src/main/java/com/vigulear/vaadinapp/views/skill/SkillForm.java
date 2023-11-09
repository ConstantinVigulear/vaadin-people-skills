package com.vigulear.vaadinapp.views.skill;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.shared.Registration;
import com.vigulear.vaadinapp.data.entity.Skill;
import com.vigulear.vaadinapp.data.entity.SkillDomain;
import com.vigulear.vaadinapp.data.entity.SkillLevel;
import com.vigulear.vaadinapp.views.person.PeopleView;

import java.util.List;

/**
 * @author Constantin Vigulear
 */

public class SkillForm extends FormLayout {
    Binder<Skill> binder = new BeanValidationBinder<>(Skill.class);
    TextField name = new TextField("Name");
    ComboBox<SkillDomain> domain = new ComboBox<>("Domain");
    ComboBox<SkillLevel> level = new ComboBox<>("Level");

    Button people = new Button("People");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button cancel = new Button("Cancel");
    private Skill skill;

    public SkillForm(List<SkillDomain> skillDomains, List<SkillLevel> skillLevels) {
        addClassName("skill-form");
        binder.bindInstanceFields(this);

        domain.setItems(skillDomains);
        domain.setItemLabelGenerator(SkillDomain::getName);

        level.setItems(skillLevels);
        level.setItemLabelGenerator(SkillLevel::getName);

        add(name, domain, level, people, createButtonsLayout());
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
        binder.readBean(skill);
    }

    public void preparePeopleButton() {
        RouterLink link = new RouterLink("", PeopleView.class);
        link.setHighlightCondition(HighlightConditions.sameLocation());

        people.addClickListener(
                event ->
                        getUI().ifPresent(ui -> ui.navigate(link.getHref() + "/" + skill.getId())));
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, skill)));
        cancel.addClickListener(event -> fireEvent(new CloseEvent(this)));

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, cancel);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(skill);
            fireEvent(new SaveEvent(this, skill));
        } catch (ValidationException e) {
            Notification.show(e.getMessage(), 1500, Notification.Position.MIDDLE);
        }
    }

    public static abstract class SkillFormEvent extends ComponentEvent<SkillForm> {
        private final Skill skill;

        protected SkillFormEvent(SkillForm source, Skill skill) {
            super(source, false);
            this.skill = skill;
        }

        public Skill getSkill() {
            return skill;
        }
    }

    public static class SaveEvent extends SkillFormEvent {
        SaveEvent(SkillForm source, Skill skill) {
            super(source, skill);
        }
    }

    public static class DeleteEvent extends SkillFormEvent {
        DeleteEvent(SkillForm source, Skill skill) {
            super(source, skill);
        }
    }

    public static class CloseEvent extends SkillFormEvent {
        CloseEvent(SkillForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
