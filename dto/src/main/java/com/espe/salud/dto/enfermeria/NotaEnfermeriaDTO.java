package com.espe.salud.dto.enfermeria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class NotaEnfermeriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado;
    private String preConsulta;
    private String postConsulta;
    private SignoVitalDTO signoVital;
    private AntropometriaDTO antropometria;
}
