package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.TipoExamenSexualDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter

public class ExamenSexualDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate fecha;

    private Long idNombreExamen;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private TipoExamenSexualDTO nombreExamen;
    private Integer tiempoAnios;
    private String resultado;

    @NotNull
    private Long idAntecedentePersonal;
}
