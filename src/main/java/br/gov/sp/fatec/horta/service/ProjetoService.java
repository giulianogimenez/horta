package br.gov.sp.fatec.horta.service;

import br.gov.sp.fatec.horta.model.PlantasProjeto;
import br.gov.sp.fatec.horta.model.Projeto;
import br.gov.sp.fatec.horta.model.Usuario;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Giuliano
 */
@RequestScoped
public class ProjetoService {
    private final EntityManager em;

    public ProjetoService() {
        this(null);
    }
    
    @Inject
    public ProjetoService(EntityManager em) {
        this.em = em;
    }

    
    public Projeto carregar(Long id) {
        return em.find(Projeto.class, id);
    }
    
    public List<Projeto> listaProjetosPorUsuario(Long id) {
        return em.createQuery("SELECT p FROM Projeto p WHERE p.usuario.id = :usuario").setParameter("usuario", id).getResultList();
    }
    
    public List<PlantasProjeto> listarPlantasPorProjeto(Projeto projeto) {
        return em.createQuery("SELECT pp FROM PlantasProjeto pp WHERE pp.projeto = :projeto ORDER BY pp.planta.nome")
                .setParameter("projeto", projeto)
                .getResultList();
    }
    
    public Boolean inserir(Projeto projeto) {
        try {
            em.persist(projeto);
            return Boolean.TRUE;
        } catch(Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
    
    public Boolean atualizar(Projeto projeto) {
        try {
            em.merge(projeto);
            return Boolean.TRUE;
        } catch(Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
    
    public Boolean deletar(Projeto projeto) {
        try {
            em.remove(projeto);
            return Boolean.TRUE;
        } catch(Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
