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

		getFullNameById();
		// getNameById();
		// create();
		// update();
		// delete();
		// deleteCR();
		// list();
		// findOne();

	}

	@Transactional(readOnly = true)
	public void getNameById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("================== Consulta solo del nombre por id ==================");
		System.out.println("Ingrese el id de la persona a buscar:");
		Long id = scanner.nextLong();
		String name = personRepository.getNameById(id);
		System.out.println(name);
		scanner.close();
	}

	@Transactional(readOnly = true)
	public void getFullNameById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("================== Consulta nombre completo por id ==================");
		System.out.println("Ingrese el id de la persona a buscar:");
		Long id = scanner.nextLong();
		String name = personRepository.getFullNameById(id);
		System.out.println(name);
		scanner.close();
	}

	@Transactional
	public void create() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("================== Crear persona ==================");
		System.out.println("Ingrese el nombre");
		String name = scanner.nextLine();
		System.out.println("Ingrese el apellido");
		String lastName = scanner.nextLine();
		System.out.println("Ingrese el lenguaje de programacion");
		String programmingLanguage = scanner.nextLine();
		Person person = new Person(null, name, lastName, programmingLanguage);
		personRepository.save(person);

		scanner.close();
	}

	@Transactional
	public void update() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("================== Actualizar persona ==================");
		System.out.println("Ingrese el id de la persona a actualizar:");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = personRepository.findById(id);

		optionalPerson.ifPresent(person -> {
			System.out.println(person);
			System.out.println("Ingrese el lenguaje de programacion:");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person personUpdated = personRepository.save(person);
			System.out.println(personUpdated);
		});

		scanner.close();
	}

	@Transactional
	public void delete() {
		personRepository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("================== Eliminar persona ==================");
		System.out.println("Ingrese el id de la persona a eliminar:");
		Long id = scanner.nextLong();
		personRepository.deleteById(id);

		scanner.close();
	}

	@Transactional
	public void deleteCR() {
		personRepository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("================== Eliminar persona CRUD ==================");
		System.out.println("Ingrese el id de la persona a eliminar:");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = personRepository.findById(id);

		optionalPerson.ifPresentOrElse(personRepository::delete,
				() -> System.out.println("No se encontro la persona"));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void findOne() {
		personRepository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("================== Buscar persona por id ==================");
		System.out.println("Ingrese el id de la persona a buscar:");
		Long id = scanner.nextLong();
		Optional<Person> optionalPerson = personRepository.findById(id);

		optionalPerson.ifPresent(System.out::println);

		scanner.close();
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
		System.out.println("================== Listar personas ==================");
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
