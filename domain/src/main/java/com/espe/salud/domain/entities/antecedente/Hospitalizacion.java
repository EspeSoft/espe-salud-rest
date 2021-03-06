package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.paciente.Paciente;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTHOS", schema = "SALUD")
public class Hospitalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTHOS_CODIGO")
    private Long codigo;

    @Column(name = "MZSTHOS_FECHA_INGRESO")
    private LocalDate fechaIngreso;

    @Column(name = "MZSTHOS_CASA_SALUD")
    private String casaSalud;

    @Column(name = "MZSTHOS_DIAGNOSTICO_INGRESO")
    private String diagnosticoIngreso;

    @Column(name = "MZSTHOS_EVOLUCION_PROCEDIMIENTO_COMPLICACIONES", columnDefinition = "TEXT")
    private String evolucionProcedimientoComplicaciones;

    @Column(name = "MZSTHOS_DIAGNOSTICO_EGRESO")
    private String diagnosticoEgreso;

    @Column(name = "MZSTHOS_TIEMPO_ESTADIA")
    private String tiempoEstadia;

    @Column(name = "MZSTHOS_FECHA_ALTA")
    private LocalDate fechaAlta;

    @Column(name = "MZSTHOS_DIAS_INCAPACIDAD")
    private Integer diasIncapacidad;

    @Column(name = "MZSTHOS_INDICACIONES_ALTA")
    private String indicacionesAlta;

    @Column(name = "MZSTHOS_TIPO_EGRESO")
    private String tipoEgreso;

    @Column(name = "MZSTHOS_MEDICO_TRATANTE")
    private String medicoTratante;

    @Column(name = "MZSTHOS_ESPECIALIDAD_MEDICO")
    private String especialidadMedico;

    @Column(name = "FK_PAC_HOS")
    private Long idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAC_HOS", insertable = false, updatable = false, nullable = false)
    private Paciente paciente;

    @CreatedBy
    @Column(name = "MZSTHOS_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTHOS_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTHOS_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTHOS_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}
