package com.vigulear.vaadinapp.data.service;

import com.vaadin.flow.component.notification.Notification;
import com.vigulear.vaadinapp.data.entity.SkillLevel;
import com.vigulear.vaadinapp.data.entity.Person;
import com.vigulear.vaadinapp.data.entity.Skill;
import com.vigulear.vaadinapp.data.entity.SkillDomain;
import com.vigulear.vaadinapp.data.repository.PersonRepository;
import com.vigulear.vaadinapp.data.repository.DomainRepository;
import com.vigulear.vaadinapp.data.repository.LevelRepository;
import com.vigulear.vaadinapp.data.repository.SkillRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

/**
 * @author Constantin Vigulear
 */
@Service
public class PersonSkillService {
  private final PersonRepository personRepository;
  private final SkillRepository skillRepository;
  private final LevelRepository levelRepository;
  private final DomainRepository domainRepository;

  private final ExampleMatcher skillMatcher =
      ExampleMatcher.matching()
          .withIgnorePaths("id")
          .withIgnorePaths("version")
          .withMatcher("name", ignoreCase())
          .withMatcher("skillDomain", ignoreCase())
          .withMatcher("skillLevel", ignoreCase());

  public PersonSkillService(
      PersonRepository personRepository,
      SkillRepository skillRepository,
      LevelRepository levelRepository,
      DomainRepository domainRepository) {
    this.personRepository = personRepository;
    this.skillRepository = skillRepository;
    this.levelRepository = levelRepository;
    this.domainRepository = domainRepository;
  }

  public List<Person> findAllPeople(String stringFilter) {
    if (stringFilter == null || stringFilter.isEmpty()) {
      return personRepository.findAll();
    } else {
      return personRepository.search(stringFilter);
    }
  }

  public void deletePerson(Person person) {
    personRepository.delete(person);
  }

  public void savePerson(Person person) {
    if (person == null) {
      System.err.println("Person is null");
      return;
    }

    personRepository.save(person);
    Notification.show("Saved", 3000, Notification.Position.MIDDLE);
  }

  public List<Skill> findAllSkills(String stringFilter) {
    if (stringFilter == null || stringFilter.isEmpty()) {
      return skillRepository.findAll();
    } else {
      return skillRepository.search(stringFilter);
    }
  }

  public Person findPersonWithSkillsById(Long personId) {
    return personRepository.findPersonWithSkillsById(personId).orElse(null);
  }

  public Skill findSkillsWithPeopleById(Long skillId) {
    return skillRepository.findSkillsWithPeopleById(skillId).orElse(null);
  }

  public void deleteSkill(Skill skill) {
    skillRepository.delete(skill);
    Notification.show("Deleted", 1500, Notification.Position.MIDDLE);
  }

  public void saveSkill(Skill skill) {
    if (skill == null) {
      System.err.println("Skill is null");
      return;
    }

    Skill skillToDelete =
        skillRepository.findSkillByNameAndSkillDomainAndSkillLevel(
            skill.getName(), skill.getDomain(), skill.getLevel());

    if (skillToDelete != null) {
      Notification.show("This skill already exists!", 1500, Notification.Position.TOP_CENTER);
    } else {
      skillRepository.save(skill);
      Notification.show("Saved", 1500, Notification.Position.MIDDLE);
    }
  }

  public List<SkillDomain> findAllDomains() {
    return domainRepository.findAll();
  }

  public List<SkillLevel> findAllLevels() {
    return levelRepository.findAll();
  }

  public void addSkillToPerson(Skill newSkill, Long personId) {
    Person person = this.findPersonWithSkillsById(personId);
    Skill skill =
        skillRepository.findSkillByNameAndSkillDomainAndSkillLevel(
            newSkill.getName(), newSkill.getDomain(), newSkill.getLevel());

    if (skill == null) {
      person.getSkills().add(newSkill);
      personRepository.save(person);
    } else {
      if (person.getSkills().contains(skill)) {
        Notification.show(
            "This person already has this skill!", 1500, Notification.Position.MIDDLE);
      } else {
        person.getSkills().add(skill);
        personRepository.save(person);
        Notification.show("Added", 1500, Notification.Position.MIDDLE);
      }
    }
  }

  public void addPersonToSkill(Person newPerson, Long skillId) {
    Skill skill = this.findSkillsWithPeopleById(skillId);
    Person person =
        personRepository.findPersonByFirstNameAndLastNameAndEmail(
            newPerson.getFirstName(), newPerson.getLastName(), newPerson.getEmail());

    if (person == null) {
      skill.getPersons().add(newPerson);
      skillRepository.save(skill);
    } else {
      if (skill.getPersons().contains(person)) {
        Notification.show(
            "This skill already belongs to that person!", 1500, Notification.Position.MIDDLE);
      } else {
        skill.getPersons().add(person);
        skillRepository.save(skill);
        Notification.show("Added", 1500, Notification.Position.MIDDLE);
      }
    }
  }

  public void removeSkillFromPerson(Long skillId, Long personId) {
    Person person = this.findPersonWithSkillsById(personId);
    Skill skill = skillRepository.findById(skillId).orElse(null);

    if (person != null && skill != null) {
      person.getSkills().remove(skill);
      personRepository.save(person);
      Notification.show("Removed", 1500, Notification.Position.MIDDLE);
    }
  }

  public void removePersonFromSkill(Long skillId, Long personId) {
    Skill skill = this.findSkillsWithPeopleById(skillId);
    Person person = personRepository.findById(personId).orElse(null);

    if (person != null && skill != null) {
      skill.getPersons().remove(person);
      skillRepository.save(skill);
      Notification.show("Removed", 1500, Notification.Position.MIDDLE);
    }
  }

  public boolean checkExists(Skill skill) {
    Example<Skill> example = Example.of(skill, skillMatcher);

    return skillRepository.exists(example);
  }
}
