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
@Table(name = "MZSTRECLAB", schema = "SALUD")
public class RecordLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTRECLAB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTRECLAB_FECHA_REGISTRO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fechaRegistro;

    @Column(name = "MZSTRECLAB_CAUSA")
    @Size(max=50)
    @NotEmpty
    private String causa;

    @Column(name = "MZSTRECLAB_EDAD")
    private int edad;

    @Column(name = "MZSTRECLAB_FECHA_SALIDA")
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSalidad;

    @Column(name = "MZSTRECLAB_FECHA_REINGRESO")
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaReingreso;

    @Column(name = "MZSTRECLAB_DIAS_ENTRE_SALIDO_INGRESO")
    private int diasEntreSalidoIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "FK_EMP_RECLAB", insertable = false, updatable = false)
    private Empleado empleado;

    @CreatedDate
    @Column(name = "MZSTRECLAB_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTRECLAB_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTRECLAB_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTRECLAB_USUARIO_MODIFICACION")
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
