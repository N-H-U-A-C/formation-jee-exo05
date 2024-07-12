package dev.cb.dogs.model;

import java.time.LocalDate;

public class Dog {

    private Long id;
    private String name;
    private String breed;
    private LocalDate birthDate;

    public Dog() {
    }

    public Dog(String name, String breed, LocalDate birthDate) {
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
    }

    public Dog(Long id, String name, String breed, LocalDate birthDate) {
        this(name, breed, birthDate);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
