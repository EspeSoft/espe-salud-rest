package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.usuario.Usuario;
import com.espe.salud.domain.enums.TipoDispensario;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTCDIS", schema = "SALUD")
public class Dispensario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCDIS_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCDIS_INSTITUCION_SISTEMA")
    private String institucionSistema;

    @Column(name = "MZSTCDIS_UNIDAD_OPERATIVA")
    private String unidadOperativa;

    @Column(name = "MZSTCDIS_UNI_CODIGO")
    private String uniCodigo;

    @Column(name = "MZSTCDIS_NOMBRE_IMAGEN")
    @Enumerated(EnumType.STRING)
    private TipoDispensario nombreImagen;

    @OneToMany(mappedBy = "dispensario", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;
}
