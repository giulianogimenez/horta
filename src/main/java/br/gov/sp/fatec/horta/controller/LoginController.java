package br.gov.sp.fatec.horta.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.gov.sp.fatec.horta.model.Usuario;
import br.gov.sp.fatec.horta.service.UsuarioService;
import br.gov.sp.fatec.horta.util.UsuarioSession;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author giuliano.gimenez
 */
@Controller
public class LoginController {
    private final Result result;
    private final UsuarioService usuarioService;
    private final UsuarioSession usuarioSession;
    private final HttpServletRequest request;
    
    public LoginController() {
        this(null, null, null, null);
    }

    @Inject
    public LoginController(Result result, UsuarioService usuarioService, UsuarioSession usuarioSession, HttpServletRequest request) {
        this.result = result;
        this.usuarioService = usuarioService;
        this.usuarioSession = usuarioSession;
        this.request = request;
    }
    
    @Path("/login")
    @Get
    public void login() {
        
    }
    
    @Path("/sair")
    @Get
    public void sair() {
        usuarioSession.kill();
        HttpSession session = request.getSession();
        session.setAttribute("usuarioSession", null);
        result.redirectTo(this).login();
    }
    
    @Path("/login")
    @Post
    public void autenticar(String email, String senha) {
        Usuario u = usuarioService.autenticar(email, senha);
        if(u == null || u.getId() == null) {
            result.include("msg", "Login ou senha incorretos.");
            result.redirectTo(this).login();
        } else {
            gravarAutenticacaoSession(u);
            result.redirectTo(HomeController.class).home();
        }
    }
    
    private void gravarAutenticacaoSession(Usuario usuario) {
        HttpSession session = request.getSession();
        usuarioSession.setNome(usuario.getNome());
        usuarioSession.setId(usuario.getId());
        session.setAttribute("usuarioSession", usuarioSession);
    }
}
