package br.gov.sp.fatec.horta.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.gov.sp.fatec.horta.service.PlantaService;
import br.gov.sp.fatec.horta.util.UsuarioSession;
import javax.inject.Inject;

/**
 *
 * @author giuliano.gimenez
 */
@Controller
public class HomeController {
    private final Result result;
    private final PlantaService plantaService;
    private final UsuarioSession usuarioSession;
    public HomeController() {
        this(null, null, null);
    }

    @Inject
    public HomeController(Result result, PlantaService plantaService, UsuarioSession usuarioSession) {
        this.result = result;
        this.plantaService = plantaService;
        this.usuarioSession = usuarioSession;
    }
    
    @Path("/home")
    @Get
    public void home() {
        result.include("usuarioSession", usuarioSession);
        result.include("plantas",plantaService.listarPlantas());
    }
    
    
}
