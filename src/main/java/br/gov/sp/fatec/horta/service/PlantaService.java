package br.gov.sp.fatec.horta.service;

import br.gov.sp.fatec.horta.model.Planta;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author giuliano.gimenez
 */
@RequestScoped
public class PlantaService {
    private final EntityManager em;

    public PlantaService() {
        this(null);
    }

    @Inject
    public PlantaService(EntityManager em) {
        this.em = em;
    }
    
    public List<Planta> listarPlantas() {
        return em.createQuery("SELECT p FROM Planta p").getResultList();
    }

    public Planta carregar(Long id) {
        return em.find(Planta.class, id);
    }
}
