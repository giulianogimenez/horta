package br.gov.sp.fatec.horta.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFactoryProducer {

    private final EntityManagerFactory factory;

    public EntityManagerFactoryProducer() {
        this.factory = Persistence.createEntityManagerFactory("default");
    }

    @Produces
    public EntityManagerFactory getInstance() {
        return this.factory;
    }
}
