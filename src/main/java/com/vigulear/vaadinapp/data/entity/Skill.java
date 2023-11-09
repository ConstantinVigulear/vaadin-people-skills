package com.vigulear.vaadinapp.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
public class Skill extends AbstractEntity{

  @NotEmpty
  private String name;

@NotNull
@ManyToOne
  private SkillDomain skillDomain;

  @NotNull
  @ManyToOne
  private SkillLevel skillLevel;

  @ManyToMany(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(
          name = "PEOPLE_SKILLS",
          joinColumns = @JoinColumn(name = "SKILL_ID"),
          inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
  private Set<Person> persons = new HashSet<>();

//  @NotEmpty
//  @Formula("(int) (this.getDomain().getBasePrice() * (1 + (double) level.getLevelValue() / 10))")
//  private int skillPrice;

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

//  public Integer getSkillPrice() {
//    return skillPrice;
//  }
//
//  public void setSkillPrice(Integer skillPrice) {
//    this.skillPrice = skillPrice;
//  }
}
