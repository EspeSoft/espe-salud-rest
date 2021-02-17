package com.espe.salud.dto.odontologia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
<<<<<<< HEAD:dto/src/main/java/com/espe/salud/dto/odontologia/ExamenSistemaEstomatognaticoDTO.java
public class ExamenSistemaEstomatognaticoDTO implements Serializable {

=======
public class TipoEstudioComplementarioDTO implements Serializable {
>>>>>>> origin/TASK-29:dto/src/main/java/com/espe/salud/dto/catalogo/TipoEstudioComplementarioDTO.java
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
<<<<<<< HEAD:dto/src/main/java/com/espe/salud/dto/odontologia/ExamenSistemaEstomatognaticoDTO.java
    private String unidadEstomatognatica;
    private String codigoCIEAsociado;
    private Long historiaId;
=======
    private String nombre;
>>>>>>> origin/TASK-29:dto/src/main/java/com/espe/salud/dto/catalogo/TipoEstudioComplementarioDTO.java
}
