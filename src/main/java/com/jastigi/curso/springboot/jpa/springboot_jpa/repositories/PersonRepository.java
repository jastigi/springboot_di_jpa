package com.jastigi.curso.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jastigi.curso.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.jastigi.curso.springboot.jpa.springboot_jpa.entities.Person;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.name between 'J' and  'P'")
    List<Person> findByNameBetween();

    @Query("select p from Person p where p.id between 2 and 5")
    List<Person> findByIdBetween();

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
