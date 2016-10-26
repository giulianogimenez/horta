package br.gov.sp.fatec.horta.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author giuliano.gimenez
 */
@Entity
@Table(name="prj_projeto")
public class Projeto implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="prj_id")
    private Long id;
    
    @Column(name="prj_nome")
    private String nome;
    
    @ManyToOne
    @JoinColumn(columnDefinition = "usu_id", referencedColumnName = "usu_id")
    private Usuario usuario;
    

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


