package br.gov.sp.fatec.horta.model;

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
public class Planta {
    @Id
    @GeneratedValue
    @Column(name = "pln_id")
    private Long id;
    
    @Column(name = "pln_nome")
    private String nome;

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
    
}
