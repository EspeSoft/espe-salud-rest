package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.enums.TipoSubdivision;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCSUB", schema = "SALUD" )
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCSUB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCSUB_ID_STRING")
    private String idString;

    @Column(name = "MZSTCSUB_NOMBRE")
    private String nombre;

    @Column(name = "MZSTCSUB_CODIGO1")
    private String codigo1;

    @Column(name = "MZSTCSUB_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoSubdivision tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAI_SUB", updatable = false, insertable = false)
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SUB_SUB")
    private Subdivision padre;
}
