package com.espe.salud.domain.entities.ocupacional;

import com.espe.salud.domain.entities.catalogo.*;
import com.espe.salud.domain.entities.usuario.Usuario;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTFACRIEPUEACT", schema = "SALUD")
public class FactorRiesgoPuestoActual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTFACRIEPUEACT_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTFACRIEPUEACT_PUESTO_TRABAJO")
    private String puestoTrabajo;

    @Column(name = "MZSTFACRIEPUEACT_ACTIVIDAD_PUESTO")
    private String actividadPuesto;

    @Column(name = "MZSTFACRIEPUEACT_MEDIDA_PREVENTIVA")
    private String medidaPreventiva;

    @Column(name = "MZSTFACRIEPUEACT_MAQUINARIA")
    private String maquinaria;

    @Column(name = "FK_ANTLAB_FACRIEPUEACT")
    private Long idAntecedenteLaboral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTLAB_FACRIEPUEACT", insertable = false, updatable = false)
    private AntecedenteLaboral antecedenteLaboral;

    @JoinTable(
            name = "MZSTREL_RIEFIS_FACRIEPUEACT",
            joinColumns = @JoinColumn(name = "FK_FACRIEPUEACT", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_RIEFIS", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<RiesgoFisico> riesgosFisico;

    @JoinTable(
            name = "MZSTREL_RIEQUI_FACRIEPUEACT",
            joinColumns = @JoinColumn(name = "FK_FACRIEPUEACT", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_RIEQUI", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<RiesgoQuimico> riesgosQuimico;

    @JoinTable(
            name = "MZSTREL_RIEMEC_FACRIEPUEACT",
            joinColumns = @JoinColumn(name = "FK_FACRIEPUEACT", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_RIEMEC", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<RiesgoMecanico> riesgosMecanico;

    @JoinTable(
            name = "MZSTREL_RIEERG_FACRIEPUEACT",
            joinColumns = @JoinColumn(name = "FK_FACRIEPUEACT", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_RIEERG", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<RiesgoErgonomico> riesgosErgonomico;

    @JoinTable(
            name = "MZSTREL_RIEBIO_FACRIEPUEACT",
            joinColumns = @JoinColumn(name = "FK_FACRIEPUEACT", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_RIEBIO", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<RiesgoBiologico> riesgosBiologico;

    @JoinTable(
            name = "MZSTREL_RIEPSI_FACRIEPUEACT",
            joinColumns = @JoinColumn(name = "FK_FACRIEPUEACT", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_RIEPSI", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<RiesgoPsicosocial> riesgosPsicosocial;

    @CreatedDate
    @Column(name = "MZSTFACRIEPUEACT_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTFACRIEPUEACT_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTFACRIEPUEACT_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTFACRIEPUEACT_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    public void addRiesgosFisico(RiesgoFisico riesgoFisico) {
        if (this.riesgosFisico == null)
            this.riesgosFisico = new ArrayList<>();
        this.riesgosFisico.add(riesgoFisico);
    }

    public void addRiesgosQuimico(RiesgoQuimico riesgoQuimico) {
        if (this.riesgosQuimico == null)
            this.riesgosQuimico = new ArrayList<>();
        this.riesgosQuimico.add(riesgoQuimico);
    }

    public void addRiesgosMecanico(RiesgoMecanico riesgoMecanico) {
        if (this.riesgosMecanico == null)
            this.riesgosMecanico = new ArrayList<>();
        this.riesgosMecanico.add(riesgoMecanico);
    }

    public void addRiesgosBiologico(RiesgoBiologico riesgoBiologico) {
        if (this.riesgosBiologico == null)
            this.riesgosBiologico = new ArrayList<>();
        this.riesgosBiologico.add(riesgoBiologico);
    }

    public void addRiesgosErgonomico(RiesgoErgonomico riesgoErgonomico) {
        if (this.riesgosErgonomico == null)
            this.riesgosErgonomico = new ArrayList<>();
        this.riesgosErgonomico.add(riesgoErgonomico);
    }

    public void addRiesgosPsicosocial(RiesgoPsicosocial riesgoPsicosocial) {
        if (this.riesgosPsicosocial == null)
            this.riesgosPsicosocial = new ArrayList<>();
        this.riesgosPsicosocial.add(riesgoPsicosocial);
    }

}
