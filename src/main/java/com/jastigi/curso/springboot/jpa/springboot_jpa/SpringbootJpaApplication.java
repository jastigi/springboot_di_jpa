package com.jastigi.curso.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.jastigi.curso.springboot.jpa.springboot_jpa.dto.PersonDto;
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

		// getFullNameById();
		// getNameById();
		// create();
		// update();
		// delete();
		// deleteCR();
		// list();
		// findOne();
		// obtenerPersonDataFullById();
		// obtenerPersonDataFull();
		// findAllMixPerson();
		// findAllObjectPersonPersonalized();
		// findAllPersonDto();
		// findAllNamesDistinct();
		// findAllProgrammingLanguagesDistinct();
		// findAllProgrammingLanguagesDistinctCount();
		// findAllFullNameConcat();
		// findAllFullNameConcatUpper();
		// findAllFullNameConcatLower();
		// findByIdBetween();
		findByNameBetween();
	}

	@Transactional(readOnly = true)
	public void findByNameBetween() {
		System.out.println("================== Consulta personas por nombre entre J y P ==================");
		List<Person> persons = personRepository.findByNameBetween();
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findByIdBetween() {
		System.out.println("================== Consulta personas por id entre 2 y 5 ==================");
		List<Person> persons = personRepository.findByIdBetween();
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findAllFullNameConcatLower() {
		System.out.println("================== Consulta nombre completo concatenado en minusculas ==================");
		List<String> fullNames = personRepository.findAllFullNameConcatLower();
		fullNames.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findAllFullNameConcatUpper() {
		System.out.println("================== Consulta nombre completo concatenado en mayusculas ==================");
		List<String> fullNames = personRepository.findAllFullNameConcatUpper();
		fullNames.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findAllFullNameConcat() {
		System.out.println("================== Consulta nombre completo concatenado ==================");
		List<String> fullNames = personRepository.findAllFullNameConcat();
		fullNames.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findAllProgrammingLanguagesDistinctCount() {
		System.out.println(
				"================== Consulta del total de lenguajes de programacion con Count ==================");
		Long count = personRepository.findAllProgrammingLanguagesDistinctCount();
		System.out.println("Total de lenguajes de programacion: " + count);
	}

	@Transactional(readOnly = true)
	public void findAllProgrammingLanguagesDistinct() {
		System.out.println(
				"================== Consulta solo del lenguaje de programacion con Distinct ==================");
		List<String> programmingLanguages = personRepository.findAllProgrammingLanguagesDistinct();
		programmingLanguages.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findAllNamesDistinct() {
		System.out.println("================== Consulta solo del nombre con Distinct ==================");
		List<String> names = personRepository.findAllNamesDistinct();
		names.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findAllPersonDto() {
		System.out.println(
				"================== Consulta datos completos de personas personalizados Dto ==================");
		List<PersonDto> persons = personRepository.findAllPersonDto();
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findAllObjectPersonPersonalized() {
		System.out.println("================== Consulta datos completos de personas personalizados ==================");
		List<Person> persons = personRepository.findAllObjectPersonPersonalized();
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findAllMixPerson() {
		System.out.println("================== Consulta datos completos de personas ==================");
		List<Object[]> persons = personRepository.findAllMixPerson();
		persons.forEach(personFull -> {
			System.out.println("programmingLanguage = " + personFull[1] + " " + personFull[0]);
		});
	}

	@Transactional(readOnly = true)
	public void obtenerPersonDataFullById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("================== Consulta datos completos de una persona por id ==================");
		System.out.println("Ingrese el id de la persona a buscar:");
		Long id = scanner.nextLong();
		Object[] person = (Object[]) personRepository.obtenerPersonDataFullById(id);
		System.out.println("id = " + person[0]);
		System.out.println("name = " + person[1]);
		System.out.println("lastName = " + person[2]);
		System.out.println("programmingLanguage = " + person[3]);
		scanner.close();
	}

	@Transactional(readOnly = true)
	public void obtenerPersonDataFull() {
		System.out.println("================== Consulta datos completos de personas ==================");
		List<Object[]> persons = personRepository.obtenerPersonDataFull();
		persons.forEach(personFull -> {
			System.out.println("id = " + personFull[0]);
			System.out.println("name = " + personFull[1]);
			System.out.println("lastName = " + personFull[2]);
			System.out.println("programmingLanguage = " + personFull[3]);
		});
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
