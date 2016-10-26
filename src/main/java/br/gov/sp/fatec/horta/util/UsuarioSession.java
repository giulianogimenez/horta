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
    private String email;

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
    
    public void kill() {
        this.id = null;
        this.email = null;
    }
}
