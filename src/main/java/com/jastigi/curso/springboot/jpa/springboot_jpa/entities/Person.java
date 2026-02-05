package com.jastigi.curso.springboot.jpa.springboot_jpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;

    @Column(name = "programming_language")
    private String programmingLanguage;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Person() {
    }

    public Person(Long id, String name, String lastName, String programmingLanguage) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.programmingLanguage = programmingLanguage;
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @PrePersist
    public void prePersist() {
        System.out.println("Evento del ciclo de vida de la entidad: PrePersist");
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Evento del ciclo de vida de la entidad: PreUpdate");
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", programmingLanguage="
                + programmingLanguage + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
