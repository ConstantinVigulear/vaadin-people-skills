package com.vigulear.vaadinapp.data.repository;

import com.vigulear.vaadinapp.data.entity.Skill;
import com.vigulear.vaadinapp.data.entity.SkillDomain;
import com.vigulear.vaadinapp.data.entity.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Constantin Vigulear
 */
public interface SkillRepository extends JpaRepository<Skill, Long> {
  @Query(
      "select s from Skill s " + "where lower(s.name) like lower(concat('%', :searchTerm, '%')) ")
  List<Skill> search(@Param("searchTerm") String searchTerm);
  Skill findSkillByNameAndSkillDomainAndSkillLevel(String name, SkillDomain domain, SkillLevel level);

  @Query("SELECT s FROM Skill s LEFT JOIN FETCH s.persons WHERE s.id = :skillId")
  Optional<Skill> findSkillWithPeopleById(Long skillId);
}
