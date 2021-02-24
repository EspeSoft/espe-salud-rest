package com.espe.salud.dto.examen;

import com.espe.salud.dto.catalogo.OrganoSistemaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ExamenInternoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String descripcion;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaRegistro;

    @NotNull
    private Long idPaciente;

    @NotNull
    private Long idOrganoSistema;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private OrganoSistemaDTO organoSistema;
}
