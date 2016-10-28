package br.gov.sp.fatec.horta.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.gov.sp.fatec.horta.model.Usuario;
import br.gov.sp.fatec.horta.service.UsuarioService;
import br.gov.sp.fatec.horta.util.Transacional;
import br.gov.sp.fatec.horta.util.UsuarioSession;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author giuliano.gimenez
 */
@Controller
public class SingupController {
    private final Result result;
    private final UsuarioService usuarioService;
    private final UsuarioSession usuarioSession;
    private final HttpServletRequest request;

    public SingupController() {
        this(null, null, null, null);
    }

    @Inject
    public SingupController(Result result, UsuarioService usuarioService, UsuarioSession usuarioSession, HttpServletRequest request) {
        this.result = result;
        this.usuarioService = usuarioService;
        this.usuarioSession = usuarioSession;
        this.request = request;
    }
    
    @Path("/singup")
    @Get
    public void singup() {
        
    }
    
    @Path("/singup")
    @Post
    @Transacional
    public void salvar(Usuario usuario) {
        usuarioService.inserir(usuario);
        if(usuario.getId() != null) {
            gravarAutenticacaoSession(usuario);
            result.redirectTo(HomeController.class).home();
        } else {
            result.include("msg", "Houve um problema ao realizar seu cadastro.");
        }
    }
    
    private void gravarAutenticacaoSession(Usuario usuario) {
        HttpSession session = request.getSession();
        usuarioSession.setNome(usuario.getNome());
        usuarioSession.setId(usuario.getId());
        session.setAttribute("usuarioSession", usuarioSession);
    }
}
