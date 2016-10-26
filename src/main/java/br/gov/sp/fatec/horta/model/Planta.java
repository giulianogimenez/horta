package br.gov.sp.fatec.horta.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author giuliano.gimenez
 */
@Entity
@Table(name = "pln_planta")
public class Planta implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "pln_id")
    private Long id;
    
    @Column(name = "pln_nome")
    private String nome;
    
    @Column(name = "pln_fotopath")
    private String fotoPath;
    
    @Column(name="pln_iluminacao")
    private String iluminacao;
    
    @Column(name="pln_irrigacao")
    private String irrigacao;
    
    @Column(name="pln_dica")
    private String dica;
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    public String getIluminacao() {
        return iluminacao;
    }

    public void setIluminacao(String iluminacao) {
        this.iluminacao = iluminacao;
    }

    public String getIrrigacao() {
        return irrigacao;
    }

    public void setIrrigacao(String irrigacao) {
        this.irrigacao = irrigacao;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
}
