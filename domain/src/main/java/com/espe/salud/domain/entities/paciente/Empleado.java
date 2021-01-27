package com.espe.salud.domain.entities.paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTEMP", schema = "SALUD")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTEMP_CODIGO")
    private Long codigo;

    @Column(name = "MZSTEMP_FECHA_INGRESO_LABORAL")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate fechaIngresoLaboral;

    @Column(name = "MZSTEMP_UNIDAD_DEPARTAMENTO")
    @NotEmpty
    private String unidadDepartamento;

    @Column(name = "MZSTEMP_OBSERVACION_HORARIO")
    private String observacionHorario;

    @Column(name = "MZSTEMP_PARROQUIA")
    @Size(max = 30)
    @NotEmpty
    private String parroquia;

    @Column(name = "MZSTEMP_DIRECCION_LABORAL")
    @Size(max = 200)
    @NotEmpty
    private String direccionLaboral;

    @Column(name = "MZSTEMP_AREA_TRABAJO")
    @Size(max = 100)
    @NotEmpty
    private String areaTrabajo;

    @Column(name = "MZSTEMP_CARGO_TRABAJO_ACTUAL")
    @Size(max = 100)
    private String cargoTrabajoActual;

    @Column(name = "MZSTEMP_ACTIVIDADES_RELEVANTE")
    private String actividadeRelevante;

    @Column(name = "MZSTEMP_TIPO_JORNADA_LABORAL")
    @NotEmpty
    private String tipoJornadaLaboral;

    @Column(name = "MZSTEMP_HORAS_TRABAJO_DIA")
    @NotNull
    private Integer horasTrabajoDia;

    @Column(name = "MZSTEMP_HORAS_TRABAJO_SEMANA")
    @NotNull
    private Integer horasTrabajoSemana;

    @Column(name = "MZSTEMP_HORAS_TRABAJO_MES")
    @NotNull
    private Integer horasTrabajoMes;

    @Column(name = "MZSTEMP_CUMPLE_MISION_SERVICIO")
    @NotEmpty
    private String cumpleMisionServicio;

    @Column(name = "MZSTEMP_SITUACIÓN_ADMINISTRATIVA")
    @NotEmpty
    private String situacionAdministrativa;

    @Column(name = "MZSTEMP_CODIGO_SEDE")
    @NotNull
    private Long idSede;

    @Column(name = "MZSTEMP_CODIGO_TRABAJO")
    @NotNull
    private Long idCantonTrabajo;

    @Column(name = "MZSTEMP_CODIGO_PROVINCIA_TRABAJO")
    @NotNull
    private Long idProvinciaTrabajo;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RecordLaboral> records;

    @OneToOne(mappedBy = "empleado")
    @JsonIgnore
    private Persona persona;

    @CreatedDate
    @Column(name = "MZSTEMP_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEMP_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTEMP_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEMP_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }
}
