package com.vigulear.vaadinapp.data.repository;

import com.vigulear.vaadinapp.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Constantin Vigulear
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select c from Person c " +
            "where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<Person> search(@Param("searchTerm") String searchTerm);

    @Query("SELECT p FROM Person p LEFT JOIN FETCH p.skills WHERE p.id = :personId")
    Optional<Person> findPersonWithSkillsById(Long personId);

    Person findPersonByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);

}
