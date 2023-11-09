package com.vigulear.vaadinapp.data.repository;

import com.vigulear.vaadinapp.data.entity.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Constantin Vigulear
 */
public interface LevelRepository extends JpaRepository<SkillLevel, Long> {}
