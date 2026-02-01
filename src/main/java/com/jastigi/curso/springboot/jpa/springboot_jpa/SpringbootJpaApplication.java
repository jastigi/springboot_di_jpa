package com.jastigi.curso.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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

		create();
		list();
		findOne();

	}

	@Transactional
	public void create() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre");
		String name = scanner.nextLine();
		System.out.println("Ingrese el apellido");
		String lastName = scanner.nextLine();
		System.out.println("Ingrese el lenguaje de programacion");
		String programmingLanguage = scanner.nextLine();
		Person person = new Person(null, name, lastName, programmingLanguage);
		personRepository.save(person);
	}

	@Transactional(readOnly = true)
	public void findOne() {
		// Person person = null;
		// Optional<Person> optionalPerson = personRepository.findById(1L);
		// // if (!optionalPerson.isEmpty()) {
		// if (optionalPerson.isPresent()) {
		// person = optionalPerson.get();
		// System.out.println(person);
		// } else {
		// System.out.println("No se encontro la persona");
		// }

		// personRepository.findById(1L).ifPresent(System.out::println);
		// personRepository.findOne(1L).ifPresent(System.out::println);
		// personRepository.findOneByName("Andres").ifPresent(System.out::println);
		// personRepository.findOneLikeName("ri").ifPresent(System.out::println);
		// personRepository.findByName("Josefa").ifPresent(System.out::println);
		personRepository.findByNameContaining("Jose").ifPresent(System.out::println);

	}

	@Transactional(readOnly = true)
	public void list() {
		// List<Person> persons = (List<Person>) personRepository.findAll();
		// List<Person> persons = personRepository.findByProgrammingLanguage("Java");
		// List<Person> persons = personRepository.buscarProgrammingLanguage("Java",
		// "Andres");
		List<Person> persons = personRepository.findByProgrammingLanguageAndName("Java", "Andres");

		persons.stream().forEach(System.out::println);

		List<Object[]> personData = personRepository.obtenerPersonData();
		personData.stream().forEach(person -> {
			System.out.println(person[0] + " es experto en " + person[1]);
		});
	}

}
