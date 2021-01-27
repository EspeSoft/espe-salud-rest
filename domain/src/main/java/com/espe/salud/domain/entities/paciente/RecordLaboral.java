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
@Table(name = "MZSTREC_LAB", schema = "SALUD")
public class RecordLaboral {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTREC_LAB_CODIGO")
    private Long codigo;

    @Column(name = "MZSTREC_LAB_FECHA_REGISTRO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fechaRegistro;

    @Column(name = "MZSTREC_LAB_CAUSA")
    @Size(max=50)
    @NotEmpty
    private String causa;

    @Column(name = "MZSTREC_LAB_EDAD")
    private int edad;

    @Column(name = "MZSTREC_LAB_FECHA_SALIDA")
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSalidad;

    @Column(name = "MZSTREC_LAB_FECHA_REINGRESO")
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaReingreso;

    @Column(name = "MZSTREC_LAB_DIAS_ENTRE_SALIDO_INGRESO")
    private int diasEntreSalidoIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "FK_EMP_REC_LAB", insertable = false, updatable = false)
    private Empleado empleado;

    @CreatedDate
    @Column(name = "MZSTREC_LAB_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTREC_LAB_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTREC_LAB_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTREC_LAB_USUARIO_MODIFICACION")
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
