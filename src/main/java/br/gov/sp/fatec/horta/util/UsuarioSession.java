package br.gov.sp.fatec.horta.util;

import java.io.Serializable;

/**
 *
 * @author giuliano.gimenez
 */
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
}
