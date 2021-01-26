package com.espe.salud.domain.entities.usuario;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTCARESAL", schema = "SALUD")
public class AreaSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCARESAL_CODIGO")
    private Integer codigo;

    @Column(name = "MZSTCARESAL_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "areaSalud", cascade = CascadeType.ALL)
    private List<Usuario> usuariosSalud;
}
