package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCPAI", schema = "SALUD" )
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCPAI_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCPAI_ID_STRING")
    private String idString;

    @Column(name = "MZSTCPAI_NOMBRE")
    private String nombre;

    @Column(name = "MZSTCPAI_CODIGO1")
    private String codigo1;

    @Column(name = "MZSTCPAI_CODIGO3")
    private String codigo3;

    @Column(name = "MZSTCPAI_CODIGO_NUMERICO")
    private String codigoNumerico;

}
