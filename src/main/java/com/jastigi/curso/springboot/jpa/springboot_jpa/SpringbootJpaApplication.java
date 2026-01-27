package com.jastigi.curso.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jastigi.curso.springboot.jpa.springboot_jpa.entities.Person;
import com.jastigi.curso.springboot.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// List<Person> persons = (List<Person>) personRepository.findAll();
		// List<Person> persons = personRepository.findByProgrammingLanguage("Java");
		// List<Person> persons = personRepository.buscarProgrammingLanguage("Java",
		// "Andres");
		List<Person> persons = personRepository.findByProgrammingLanguageAndName("Java", "Andres");

		persons.stream().forEach(System.out::println);

	}

}
