package com.espe.salud.dto.evolucion;

import com.espe.salud.dto.catalogo.DispensarioDTO;
import com.espe.salud.dto.catalogo.MotivoAtencionDTO;
import com.espe.salud.dto.certificado.CertificadoDTO;
import com.espe.salud.dto.enfermeria.NotaEnfermeriaDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.dto.usuario.AreaSaludDTO;
import com.espe.salud.dto.usuario.UsuarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EvolucionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;

    @NotEmpty
    private String estado;

    @NotNull
    private String motivoConsulta;

    @NotNull
    private Long idMotivoAtencion;

    @NotEmpty
    private String notaEvolucion;

    @NotNull
    private Long responsablePidm;

    private Boolean esEnfermedadOcupacional;

    @NotNull
    private Long idDispensario;

    @NotNull
    private Long idPaciente;

    @NotNull
    private Long idAreaSalud;

    private Long idNotaEnfermeria;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private DispensarioDTO dispensario;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private AreaSaludDTO areaSalud;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private MotivoAtencionDTO motivoAtencion;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private NotaEnfermeriaDTO notaEnfermeria;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private UsuarioDTO usuario;

    List<DiagnosticoDTO> diagnosticos;

    List<PrescripcionDTO> prescripciones;


}
