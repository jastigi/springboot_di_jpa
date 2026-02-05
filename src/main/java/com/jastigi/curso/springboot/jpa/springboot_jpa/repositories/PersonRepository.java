package com.jastigi.curso.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jastigi.curso.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.jastigi.curso.springboot.jpa.springboot_jpa.entities.Person;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p.name, length(p.name) from Person p where length(p.name)=(select min(length(p.name)) from Person p)")
    List<Object[]> getShorterName();

    @Query("select p from Person p where p.id=(select max(p.id) from Person p)")
    Optional<Person> getLastRegistration();

    @Query("select min(length(p.name)), max(length(p.name)), count(p), sum(p.id), avg(p.id) from Person p")
    Object getResumeAggregationFunction();

    @Query("select min(length(p.name)) from Person p")
    Integer getMinLengthName();

    @Query("select max(length(p.name)) from Person p")
    Integer getMaxLengthName();

    @Query("select p.name, length(p.name) from Person p")
    List<Object[]> getPersonNameLength();

    @Query("select count(p) from Person p")
    Long totalPerson();

    @Query("select min(p.id) from Person p")
    Long minId();

    @Query("select max(p.id) from Person p")
    Long maxId();

    @Query("select p from Person p order by p.name desc, p.lastName asc")
    List<Person> getAllOrdered();

    List<Person> findByNameBetweenOrderByNameAsc(String name1, String name2);

    List<Person> findByIdBetweenOrderByIdDesc(Long id1, Long id2);

    @Query("select p from Person p where p.name between ?1 and ?2 order by p.name")
    List<Person> findByAllNameBetween(String name1, String name2);

    @Query("select p from Person p where p.id between ?1 and ?2 order by p.name desc")
    List<Person> findByAllIdBetween(Long id1, Long id2);

    @Query("select upper(p.name || ' ' || p.lastName) from Person p")
    List<String> findAllFullNameConcatUpper();

    @Query("select lower(concat(p.name, ' ', p.lastName)) from Person p")
    List<String> findAllFullNameConcatLower();

    // @Query("select concat(p.name, ' ', p.lastName) from Person p")
    @Query("select p.name || ' ' || p.lastName from Person p")
    List<String> findAllFullNameConcat();

    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select distinct p.name from Person p")
    List<String> findAllNamesDistinct();

    @Query("select distinct p.programmingLanguage from Person p")
    List<String> findAllProgrammingLanguagesDistinct();

    @Query("select count(distinct p.programmingLanguage) from Person p")
    Long findAllProgrammingLanguagesDistinctCount();

    @Query("select new com.jastigi.curso.springboot.jpa.springboot_jpa.dto.PersonDto(p.name, p.lastName) from Person p")
    List<PersonDto> findAllPersonDto();

    @Query("select new Person(p.name, p.lastName) from Person p")
    List<Person> findAllObjectPersonPersonalized();

    @Query("select p.name from Person p where p.id=?1")
    String getNameById(Long id);

    @Query("select concat(p.name, ' ', p.lastName) from Person p where p.id=?1")
    String getFullNameById(Long id);

    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneByName(String name);

    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByName(String name);

    Optional<Person> findByNameContaining(String name);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarProgrammingLanguage(String programmingLanguage, String name);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select p.id, p.name, p.lastName, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonDataFull();

    @Query("select p.id, p.name, p.lastName, p.programmingLanguage from Person p where p.id=?1")
    Object obtenerPersonDataFullById(Long id);

    @Query("select p.name, p.programmingLanguage from Person p where p.name=?1")
    List<Object[]> obtenerPersonData(String name);

    @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1")
    List<Object[]> obtenerPersonDataByProgrammingLanguage(String programmingLanguage);

    @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Object[]> obtenerPersonData(String programmingLanguage, String name);

}
