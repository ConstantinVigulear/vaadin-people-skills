package com.vigulear.vaadinapp.data.repository;

import com.vigulear.vaadinapp.data.entity.SkillDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Constantin Vigulear
 */
public interface DomainRepository extends JpaRepository<SkillDomain, Long> {}
