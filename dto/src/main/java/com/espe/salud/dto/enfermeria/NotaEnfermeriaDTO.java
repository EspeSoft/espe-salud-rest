package com.espe.salud.dto.enfermeria;

import com.espe.salud.dto.catalogo.DispensarioDTO;
import com.espe.salud.dto.usuario.AreaSaludDTO;
import com.espe.salud.dto.usuario.UsuarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class NotaEnfermeriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime fechaInicio;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime fechaFin;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String estado;

    private String preConsulta;

    private String postConsulta;

    private SignoVitalDTO signoVital;

    private AntropometriaDTO antropometria;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private AreaSaludDTO areaSalud;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private DispensarioDTO dispensario;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UsuarioDTO usuario;

    private Long idAreaSalud;

    private Long idPaciente;

    private Long idDispensario;

    private Long idUsuario;
}
