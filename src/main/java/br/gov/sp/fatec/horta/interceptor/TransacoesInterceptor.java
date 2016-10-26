package br.gov.sp.fatec.horta.interceptor;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.gov.sp.fatec.horta.util.Transacional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@Intercepts
@AcceptsWithAnnotations(Transacional.class)
public class TransacoesInterceptor {
    
    @Inject
    private Result result;
    
    @Inject
    private EntityManager em;

    @AroundCall
    public void intercept(SimpleInterceptorStack stack) throws InterceptionException {
        try {
            em.getTransaction().begin();
            stack.next();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            result.include("msg", "Um erro ocorreu durante o processo.");
        }
    }
}
