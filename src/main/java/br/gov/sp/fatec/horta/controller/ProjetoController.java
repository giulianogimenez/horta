package br.gov.sp.fatec.horta.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.gov.sp.fatec.horta.model.Projeto;
import br.gov.sp.fatec.horta.service.ProjetoService;
import br.gov.sp.fatec.horta.util.Transacional;
import br.gov.sp.fatec.horta.util.UsuarioSession;
import javax.inject.Inject;

/**
 *
 * @author giuliano.gimenez
 */
@Controller
public class ProjetoController {
    private final Result result;
    private final ProjetoService projetoService;
    
    @Inject
    public ProjetoController(Result result, ProjetoService projetoService) {
        this.result = result;
        this.projetoService = projetoService;
    }

    public ProjetoController() {
        this(null, null);
    }
    
    @Path("/projeto")
    @Get
    public void novo() {
        
    }
    
    @Path("/projeto/planta/{id}")
    @Get
    public void planta(Long id) {
        Projeto projeto = projetoService.carregar(id);
        result.include("projeto", projeto);
        result.include("plantas", projetoService.listarPlantasPorProjeto(projeto));
    }
    
    @Path("/projeto")
    @Post
    @Transacional
    public void inserir(Projeto projeto) {
        if(projetoService.inserir(projeto)) {
            result.include("projeto", projeto);
            result.redirectTo(this).planta(projeto.getId());
        } else {
            result.include("msg", "Houve um problema ao salvar seu projeto!");
            result.redirectTo(this).novo();
        }
    }
    
    @Path("/projeto")
    @Put
    @Transacional
    public void atualizar(Projeto projeto) {
        if(projetoService.atualizar(projeto)) {
            result.include("projeto", projeto);
            result.redirectTo(this).planta(projeto.getId());
        } else {
            result.include("msg", "Houve um problema ao salvar seu projeto!");
            result.redirectTo(this).novo();
        }
    }
}
