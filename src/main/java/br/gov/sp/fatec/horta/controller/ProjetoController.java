package br.gov.sp.fatec.horta.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.gov.sp.fatec.horta.model.Planta;
import br.gov.sp.fatec.horta.model.PlantasProjeto;
import br.gov.sp.fatec.horta.model.Projeto;
import br.gov.sp.fatec.horta.service.PlantaProjetoService;
import br.gov.sp.fatec.horta.service.PlantaService;
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
    private final PlantaService plantaService;
    private final PlantaProjetoService plantaProjetoService;
    
    @Inject
    public ProjetoController(Result result, ProjetoService projetoService, PlantaService plantaService, PlantaProjetoService plantaProjetoService) {
        this.result = result;
        this.projetoService = projetoService;
        this.plantaService = plantaService;
        this.plantaProjetoService = plantaProjetoService;
    }

    public ProjetoController() {
        this(null, null, null, null);
    }
    
    @Path("/meuprojeto")
    @Get
    public void novo() {
        
    }
    
    @Path("/meuprojeto/{id}")
    @Get
    public void planta(Long id) {
        Projeto projeto = projetoService.carregar(id);
        result.include("projeto", projeto);
        result.include("plantas", projetoService.listarPlantasPorProjeto(projeto));
    }
    
    @Path("/meuprojeto/adicionarplanta/{id}")
    @Get
    public void adicionar(Long id) {
        Projeto projeto = projetoService.carregar(id);
        result.include("projeto", projeto);
        result.include("plantas", plantaService.listarPlantas());
        result.include("minhasPlantas", projetoService.listarPlantasPorProjeto(projeto));
    }
    
    @Path("/meuprojeto")
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
    
    @Path("/meuprojeto")
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
    
    @Path("/adicionarplanta/{projetoId}/{plantaId}")
    @Get
    @Transacional
    public void adicionarplanta(Long projetoId, Long plantaId) {
        Planta planta = plantaService.carregar(plantaId);
        Projeto projeto = projetoService.carregar(projetoId);
        PlantasProjeto pp = new PlantasProjeto();
        pp.setPlanta(planta);
        pp.setProjeto(projeto);
        
        if(plantaProjetoService.inserir(pp)) {
            result.use(Results.json()).withoutRoot().from(Boolean.TRUE).serialize();
        } else {
            result.use(Results.json()).withoutRoot().from(Boolean.FALSE).serialize();
        }
    }
    
    @Path("/removerplanta/{projetoId}/{plantaId}")
    @Get
    @Transacional
    public void removerplanta(Long projetoId, Long plantaId) {
        Planta planta = plantaService.carregar(plantaId);
        Projeto projeto = projetoService.carregar(projetoId);
        PlantasProjeto pp = plantaProjetoService.carregaPorPlantaProjeto(planta, projeto);
        if(pp == null) {
            result.use(Results.json()).withoutRoot().from(Boolean.FALSE).serialize();
            return;
        }
        if(plantaProjetoService.remover(pp)) {
            result.use(Results.json()).withoutRoot().from(Boolean.TRUE).serialize();
        } else {
            result.use(Results.json()).withoutRoot().from(Boolean.FALSE).serialize();
        }
    }
}
