package br.gov.sp.fatec.horta.util;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequestScoped
public class EntityManagerProducer {

    private final EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    protected EntityManagerProducer() {
        this(null);
    }
    
    @Inject
    public EntityManagerProducer(EntityManagerFactory factory) {
        this.manager = factory.createEntityManager();
    }

    @Produces
    @RequestScoped
    public EntityManager getInstance() {
        return this.manager;
    }

    @PreDestroy
    public void fechaManager() {
        this.manager.close();
    }
}