package br.gov.sp.fatec.horta.service;

import br.gov.sp.fatec.horta.model.Usuario;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author giuliano.gimenez
 */
@RequestScoped
public class UsuarioService {
    private final EntityManager em;

    public UsuarioService() {
        this(null);
    }

    @Inject
    public UsuarioService(EntityManager em) {
        this.em = em;
    }
    
    public void inserir(Usuario usuario) {
        em.persist(usuario);
    }
    
    public Usuario autenticar(String email, String senha) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email and u.senha = :senha", Usuario.class).setParameter("email", email).setParameter("senha", senha).getSingleResult();
        } catch(NoResultException nre) {
            return new Usuario();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
