package com.vigulear.vaadinapp.data.entity;

import jakarta.persistence.Entity;

@Entity
public class SkillDomain extends AbstractEntity {
  private String name;
  private Integer basePrice;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Integer basePrice) {
    this.basePrice = basePrice;
  }
}
