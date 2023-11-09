package com.vigulear.vaadinapp.data.entity;

import jakarta.persistence.Entity;

@Entity
public class SkillLevel extends AbstractEntity {

  private String name;

  private Integer levelValue;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getLevelValue() {
    return levelValue;
  }

  public void setLevelValue(Integer levelValue) {
    this.levelValue = levelValue;
  }
}
