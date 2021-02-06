package com.espe.salud.dto.usuario;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long pidm;

    @NotEmpty
    private String nombres;

    private Boolean activo;

    private Long idAreaSalud;

    private AreaSaludDTO areaSalud;

    // TODO Agregar dispensario DTO

    @NotNull
    private Long idDispensario;
}
