package br.gov.sp.fatec.horta.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author giuliano.gimenez
 */
@Entity
@Table(name="ppr_plantasprojeto")
public class PlantasProjeto implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="ppr_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "prj_id", referencedColumnName = "prj_id")
    private Projeto projeto;
    
    @ManyToOne
    @JoinColumn(name = "pln_id", referencedColumnName = "pln_id")
    private Planta planta;
    
    @Column(name="ppr_observacao")
    @Lob
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
