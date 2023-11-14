package com.vigulear.vaadinapp.views.person;

import com.vigulear.vaadinapp.data.entity.Person;
import com.vigulear.vaadinapp.data.entity.SkillDomain;
import com.vigulear.vaadinapp.data.entity.SkillLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Constantin Vigulear
 */
@SuppressWarnings("FieldCanBeLocal")
class PeopleFormTest {
  private Person markMorton;


  @BeforeEach
  void setUp() {
    markMorton = new Person();
    markMorton.setFirstName("Mark");
    markMorton.setLastName("Morton");
    markMorton.setEmail("mark.morton@gg.com");
    markMorton.setTotalCost(333.);
  }

  @Test
  public void formFieldsPopulated() {
    PersonForm personForm = new PersonForm();
    personForm.setPerson(markMorton);

    assertEquals("Mark", personForm.firstName.getValue());
    assertEquals("Morton", personForm.lastName.getValue());
    assertEquals("mark.morton@gg.com", personForm.email.getValue());
    assertEquals("333", personForm.totalCost.getValue());
  }

  @Test
  public void saveEventHasCorrectValues() {
    PersonForm personForm = new PersonForm();
    Person person = new Person();
    personForm.setPerson(person);

    personForm.firstName.setValue("John");
    personForm.lastName.setValue("Doe");
    personForm.email.setValue("john.doe@asdf.com");
    personForm.totalCost.setValue("123");

    AtomicReference<Person> savedPerson = new AtomicReference<>(null);
    personForm.addSaveListener(e -> savedPerson.set(e.getPerson()));

    personForm.save.click();

    Person saved = savedPerson.get();

    assertEquals("John", saved.getFirstName());
    assertEquals("Doe", saved.getLastName());
    assertEquals("john.doe@asdf.com", saved.getEmail());
    assertEquals(123, saved.getTotalCost());
  }
}
