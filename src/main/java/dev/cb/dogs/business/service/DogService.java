package dev.cb.dogs.business.service;

import dev.cb.dogs.business.model.Dog;
import dev.cb.dogs.persistence.DogRepository;

import java.util.List;
import java.util.Optional;

public class DogService {

    private final DogRepository dogRepository;

    public DogService() {
        this.dogRepository = new DogRepository();
    }

    // basic CRUD
    public void save(Dog dog) {
        dogRepository.save(dog);
    }

    public Optional<Dog> getById(Long id) {
        return dogRepository.findById(id);
    }

    public List<Dog> getAll() {
        return dogRepository.findAll();
    }
}
