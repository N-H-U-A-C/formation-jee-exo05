package dev.cb.dogs.persistence;

import dev.cb.dogs.business.model.Dog;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {
        standardServiceRegistry = new StandardServiceRegistryBuilder()
                .build();
        sessionFactory = new MetadataSources(standardServiceRegistry)
                .addAnnotatedClasses(Dog.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new SessionFactorySingleton();
        }
        return sessionFactory;
    }
}
