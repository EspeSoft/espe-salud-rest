package com.espe.salud.domain.entities.enfermeria;

import com.espe.salud.domain.entities.paciente.Paciente;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTSIGVIT", schema = "SALUD")
public class SignoVital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTSIGVIT_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTSIGVIT_PRESION_ARTERIAL")
    private Long presionArterial;

    @Column(name = "MZSTSIGVIT_PRESION_ARTERIAL2")
    private Long presionArterial2;

    @Column(name = "MZSTSIGVIT_FRECUENCIA_CARDIACA")
    private Double frecuenciaCardiaca;

    @Column(name = "MZSTSIGVIT_FRECUENCIA_RESPIRATORIA")
    private Double frecuenciaRespiratoria;

    @Column(name = "MZSTSIGVIT_TEMPERATURA")
    private Double temperatura;

    @Column(name = "MZSTSIGVIT_SATURACION_OXIGENO")
    private Double saturacionOxigeno;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "MZSTSIGVIT_FECHA_ULTIMA_MENSTRUACION")
    private LocalDate fechaUltimaMenstruacion;

    @OneToOne(mappedBy = "signoVital")
    private NotaEnfermeria notaEnfermeria;

    @CreatedDate
    @Column(name = "MZSTSIGVIT_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTSIGVIT_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTSIGVIT_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTSIGVIT_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
