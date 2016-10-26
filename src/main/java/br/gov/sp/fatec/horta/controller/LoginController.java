package br.gov.sp.fatec.horta.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;

/**
 *
 * @author giuliano.gimenez
 */
@Controller
public class LoginController {
    private final Result result;

    public LoginController() {
        this(null);
    }

    @Inject
    public LoginController(Result result) {
        this.result = result;
    }
    
    @Path("/login")
    @Get
    public void login() {
        
    }
}
