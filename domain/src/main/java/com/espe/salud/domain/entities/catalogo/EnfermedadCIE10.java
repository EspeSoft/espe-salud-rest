package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCENFCIE10", schema = "SALUD")
public class EnfermedadCIE10 {
    @Id
    @Basic(optional = false)
    @Column(name = "MZSTCENFCIE10_CODIGO")
    private String codigo;

    @Column(name = "MZSTCENFCIE10_NOMBRE")
    private String nombre;

    @Column(name = "FK_GRUENF_ENFCIE10")
    private String idGrupoEnfermedadCIE10;

    @Override
    public String toString() {
        return this.getNombre();
    }

    @ManyToOne
    @JoinColumn(name = "FK_GRUENF_ENFCIE10", insertable = false, updatable = false)
    private GrupoEnfermedad grupoEnfermedadCIE10;
}
