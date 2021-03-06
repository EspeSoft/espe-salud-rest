package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.paciente.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "MZSTANTPER_FRECUENCIA_ALIMENTACION")
    private String frecuenciaAlimentacion;

    @Column(name = "MZSTANTPER_PREDOMINIO_ALIMENTARIO")
    private String predominioAlimentario;

    @Column(name = "MZSTANTPER_OBSERVACION_ALIMENTACION")
    private String observacionAlimentacion;

    @NotEmpty
    @Column(name = "MZSTANTPER_HORA_SUENIO")
    private String horaSuenio;

    @NotEmpty
    @Column(name = "MZSTANTPER_HORA_DESPERTAR")
    private String horaDespertar;

    @Column(name = "MZSTANTPER_OBSERVACION_HABITO_SUENIO")
    private String observacionHabitoSuenio;

    @Column(name = "FK_PAC_ANTPER")
    private Long idPaciente;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_PAC_ANTPER", updatable = false, insertable = false, nullable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MedicacionHabitual> medicacionesHabituales;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AntecedentePatologicoPersonal> antecedentesPatologicoPersonales;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AntecedentePatologicoFamiliar> antecedentesPatologicoFamiliares;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AntecedenteQuirurgico> antecedentesQuirurgicos;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Discapacidad> discapacidades;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ActividadFisica> actividadesFisicas;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConsumoNocivo> consumosNocivos;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExamenSexual> examenesSexuales;

    @OneToMany(mappedBy = "antecedentePersonal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PlanificacionFamiliar> planificacionesFamiliares;

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
}
