package com.vigulear.vaadinapp.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author Constantin Vigulear
 */
@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
  @SequenceGenerator(name = "idGenerator", initialValue = 1000)
  private Long id;

  @Version private Integer version;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractEntity that = (AbstractEntity) o;
    return Objects.equals(getId(), that.getId()) && getVersion() == that.getVersion();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getVersion());
  }
}
