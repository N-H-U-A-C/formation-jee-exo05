package dev.cb.dogs.persistence;

import dev.cb.dogs.business.model.Dog;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class DogRepository {

    private final SessionFactory sessionFactory;

    public DogRepository() {
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public void save(Dog dog) {
        sessionFactory.inTransaction(session -> session.persist(dog));
    }

    public Optional<Dog> findById(Long id) {
        return sessionFactory.fromTransaction(session -> Optional.ofNullable(session.find(Dog.class, id)));
    }

    public List<Dog> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from Dog", Dog.class)
                        .getResultList());
    }
}
