package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCARE", schema = "SALUD")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCARE_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCARE_NOMBRE")
    private String nombre;

    @Column(name = "FK_REG_ARE")
    private Long idRegion;

    @ManyToOne
    @JoinColumn(name = "FK_REG_ARE", insertable = false, updatable = false)
    private Region region;
}
