package br.gov.sp.fatec.horta.util;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author giuliano.gimenez
 */
@Named("usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {
    private Long id;
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

    
    public void kill() {
        this.id = null;
        this.nome = null;
    }
}
