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

@Data
@Entity
@Table(name = "MZSTEST", schema = "SALUD")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTEST_CODIGO")
    private Long codigo;

    @Column(name = "MZSTEST_FECHA_INGRESO_ESPE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate fechaIngresoEspe;

    @Column(name = "MZSTEST_DEPARTAMENTO")
    @Size(max = 50)
    @NotEmpty
    private String departamento;

    @Column(name = "MZSTEST_ESCUELA")
    @Size(max = 50)
    private String escuela;

    @Column(name = "MZSTEST_CARRERA")
    @Size(max = 50)
    @NotEmpty
    private String carrera;

    @Column(name = "MZSTEST_ACTIVIDADES_RELEVANTES")
    private String actividadesRelevantes;

    @Column(name = "MZSTEST_PARROQUIA")
    private String parroquia;

    @Column(name = "MZSTEST_DIRECCION_LUGAR_ESTUDIO")
    private String direccionLugarEstudio;

    @Column(name = "MZSTEST_CODIGO_CANTON_ESTUDIO")
    private Long idCantonEstudio;

    @Column(name = "MZSTEST_CODIGO_PROVINCIA_ESTUDIO")
    private Long idProvinciaEstudio;

    @Column(name = "MZSTEST_CODIGO_SEDE")
    @NotNull
    private Long idSede;

    @OneToOne(mappedBy = "estudiante")
    @JsonIgnore
    private Persona persona;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente", referencedColumnName = "MZSTPAC_CODIGO")
    private Paciente paciente;

    @CreatedDate
    @Column(name = "MZSTEST_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEST_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTEST_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEST_USUARIO_MODIFICACION")
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
