package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCCODCIUO", schema = "SALUD")
public class CodigoCIUO {

    @Id
    @Column(name = "MZSTCCODCIUO_CODIGO")
    private String codigo;

    @Column(name = "MZSTCCODCIUO_DESCRIPCION")
    private String descripcion;

    @Column(name = "MZSTCCODCIUO_NIVEL")
    private String nivel;

}
