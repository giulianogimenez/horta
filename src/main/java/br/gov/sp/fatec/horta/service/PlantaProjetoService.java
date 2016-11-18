
package br.gov.sp.fatec.horta.service;

import br.gov.sp.fatec.horta.model.Planta;
import br.gov.sp.fatec.horta.model.PlantasProjeto;
import br.gov.sp.fatec.horta.model.Projeto;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author giuliano.gimenez
 */
@RequestScoped
public class PlantaProjetoService {
    private final EntityManager em;
    
    public PlantaProjetoService() {
        this(null);
    }
    
    @Inject
    public PlantaProjetoService(EntityManager em) {
        this.em = em;
    }

    public Boolean inserir(PlantasProjeto plantasProjeto) {
        try {
            em.persist(plantasProjeto);
            return Boolean.TRUE;
        } catch(Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public Boolean remover(PlantasProjeto plantasProjeto) {
        try {
            em.remove(plantasProjeto);
            return Boolean.TRUE;
        } catch(Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public PlantasProjeto carregaPorPlantaProjeto(Planta planta, Projeto projeto) {
        try {
            return em.createQuery("SELECT pp FROM PlantasProjeto pp WHERE pp.planta = :planta AND pp.projeto = :projeto", PlantasProjeto.class)
                    .setParameter("planta", planta)
                    .setParameter("projeto", projeto)
                    .getSingleResult();
        } catch(NoResultException nre) {
            return null;
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean atualizar(PlantasProjeto plantasProjeto) {
        try {
            em.merge(plantasProjeto);
            return Boolean.TRUE;
        } catch(Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public PlantasProjeto carregar(Long plantaProjetoId) {
        return em.find(PlantasProjeto.class, plantaProjetoId);
    }   
}
