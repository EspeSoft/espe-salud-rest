package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_REG_ARE")
    private Region region;
}
