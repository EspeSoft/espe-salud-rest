package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTCREG", schema = "SALUD")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCREG_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCREG_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Area> areas;
}
