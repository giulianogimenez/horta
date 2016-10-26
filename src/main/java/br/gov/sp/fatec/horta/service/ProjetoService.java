package br.gov.sp.fatec.horta.service;

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

    public List<Projeto> listaProjetosPorUsuario(Long id) {
        return em.createQuery("SELECT p FROM Projeto p WHERE p.usuario.id = :usuario").setParameter("usuario", id).getResultList();
    }
    
}
