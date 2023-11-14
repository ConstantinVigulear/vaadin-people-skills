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
class PeopleFormTest {
  private List<SkillDomain> domains;
  private SkillDomain domain1;
  private SkillDomain domain2;
  private List<SkillLevel> levels;
  private SkillLevel level1;
  private SkillLevel level2;
  private Person markMorton;


  @BeforeEach
  void setUp() {
    domains = new ArrayList<>();
    domain1 = new SkillDomain();
    domain1.setName("Programming");
    domain2 = new SkillDomain();
    domain2.setName("Cyber Security");
    domains.add(domain1);
    domains.add(domain2);

    levels = new ArrayList<>();
    level1 = new SkillLevel();
    level1.setName("Java Core");
    level2 = new SkillLevel();
    level2.setName("Penetration Testing");
    levels.add(level1);
    levels.add(level2);

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
