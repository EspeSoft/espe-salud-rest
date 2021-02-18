package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTANTPER", schema = "SALUD")
public class AntecedentePersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTPER_CODIGO", updatable = false, nullable = false)
    private Long codigo;


    @Column(name = "MZSTANTPER_ORIENTACION_SEXUAL")
    @NotEmpty
    private String orientacionSexual;


    @Column(name = "MZSTANTPER_IDENTIDAD_GENERO")
    @NotEmpty
    private String identidadGenero;

    @Column(name = "MZSTANTPER_POSEE_ALERGIA")
    private String poseeAlergia;

    @Column(name = "MZSTANTPER_DESCRIPCION_ALERGIA")
    private String descripcionAlergia;

    @Column(name = "MZSTANTPER_TOMA_MEDICAMENTO")
    private Boolean tomaMedicacion;

    @Column(name = "MZSTANTPER_REALIZA_ACTIVIDAD_FISICA")
    private Boolean realizaActividadFisica;

    @Column(name = "MZSTANTPER_FRECUENCIA_ALIMENTACION")
    private String frecuenciaAlimentacion;

    @Column(name = "MZSTANTPER_PREDOMINIO_ALIMENTARIO")
    private String predominioAlimentario;

    @CreationTimestamp
    @Column(name = "MZSTANTPER_HORA_SUEÑO")
    private LocalTime horaSuenio;

    @Column(name = "MZSTANTPER_HORA_DESPERTAR")
    private LocalTime horaDespertar;

    @Column(name = "MZSTANTPER_TOTAL_HORA_SUEÑO")
    private LocalTime totalHorasSuenio;

    @Column(name = "MZSTANTPER_OBSERVACION_ALIMENTACION")
    private String observacionAlimentacion;

    @Column(name = "MZSTANTPER_OBSERVACION_HABITO_SUEÑO")
    private String observacionHabitoSuenio;

    @OneToMany(mappedBy = "antecedentePersonal",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicacionHabitual> medicacionHabitual;

    @OneToMany(mappedBy = "antecedentePersonal",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AntecedentePatologicoPersonal> antecedentePatologicoPersonal;

    @OneToMany(mappedBy = "antecedentePersonal",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AntecedentePatologicoFamiliar> antecedentePatologicoFamiliar;

    @OneToMany(mappedBy = "antecedentePersonal",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AntecedenteQuirurgico> antecedenteQuirurgico;

    @OneToMany(mappedBy = "antecedentePersonal",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Discapacidad> discapacidad;

    @CreatedBy
    @Column(name = "MZSTANTPER_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTPER_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @Column(name = "MZSTANTPER_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTPER_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }



}
