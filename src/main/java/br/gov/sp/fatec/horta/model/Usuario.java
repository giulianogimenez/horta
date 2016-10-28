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
@Table(name="usu_usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="usu_id")
    private Long id;
    
    @Column(name="usu_email")
    private String email;
    
    @Column(name="usu_nome")
    private String nome;
    
    @Column(name="usu_senha")
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
