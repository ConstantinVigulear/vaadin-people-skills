package com.vigulear.vaadinapp.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Person extends AbstractEntity {

  @NotEmpty private String firstName = "";

  @NotEmpty private String lastName = "";

  @Email @NotEmpty private String email = "";

  @ManyToMany(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(
      name = "PEOPLE_SKILLS",
      joinColumns = @JoinColumn(name = "PERSON_ID"),
      inverseJoinColumns = @JoinColumn(name = "SKILL_ID"))
  @NotNull
  @JsonIgnoreProperties({"people"})
  private Set<Skill> skills = new HashSet<>();

  @Transient private Double totalCost = 0.0;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setSkills(Set<Skill> skills) {
    this.skills = skills;
  }

  public Set<Skill> getSkills() {
    return skills;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }

  public Double getTotalCost() {
    return totalCost;
  }

  public Double calculateTotalCost() {
    return getSkills().stream().mapToDouble(Skill::getSkillPrice).sum();
  }
}
