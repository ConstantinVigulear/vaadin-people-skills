package com.vigulear.vaadinapp.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
public class Skill extends AbstractEntity {

  @NotEmpty private String name;

  @NotNull @ManyToOne private SkillDomain skillDomain;

  @NotNull @ManyToOne private SkillLevel skillLevel;

  @ManyToMany(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(
      name = "PEOPLE_SKILLS",
      joinColumns = @JoinColumn(name = "SKILL_ID"),
      inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
  private Set<Person> persons = new HashSet<>();

  @Transient private Double skillPrice = 0.0;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SkillDomain getDomain() {
    return skillDomain;
  }

  public void setDomain(SkillDomain skillDomain) {
    this.skillDomain = skillDomain;
  }

  public SkillLevel getLevel() {
    return skillLevel;
  }

  public void setLevel(SkillLevel skillLevel) {
    this.skillLevel = skillLevel;
  }

  public Set<Person> getPersons() {
    return persons;
  }

  public void setPersons(Set<Person> persons) {
    this.persons = persons;
  }

  public Double getSkillPrice() {
    return skillPrice;
  }

  public void setSkillPrice(Double skillPrice) {
    this.skillPrice = skillPrice;
  }

  public Double calculateSkillPrice() {
    if (skillLevel.getName().equals("None")) {
      return 0.0;
    }
    double price =
        Double.parseDouble(skillDomain.getBasePrice().toString())
            * (1 + Double.parseDouble(skillLevel.getLevelValue().toString()) / 5);
    return Math.ceil(price);
  }
}
