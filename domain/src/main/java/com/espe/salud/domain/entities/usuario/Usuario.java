package com.espe.salud.domain.entities.usuario;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTUSU", schema = "SALUD")
public class Usuario {

    @Id
    @Column(name = "MZSTUSU_PIDM")
    private Long pidm;

    @Column(name = "MZSTUSU_NOMBRES")
    private String nombres;

    @Column(name = "MZSTUSU_ACTIVO")
    private Boolean activo;

    @Column(name = "FK_ARESAL_USU")
    private Long idAreaSalud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ARESAL_USU", insertable = false, updatable = false)
    private AreaSalud areaSalud;

    @Column(name = "FK_CDIS_USU")
    private Long idDispensario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CDIS_USU", insertable = false, updatable = false)
    private Dispensario dispensario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<NotaEnfermeria> notasEnfermeria;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ActividadEnfermeria> actividadesEnfermerias;

    @PrePersist
    void prePersist(){
        activo = true;
    }

}
