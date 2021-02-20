package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.entities.usuario.Usuario;
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
    private String nombreImagen;

    @Column(name = "MZSTCDIS_CAMPUS")
    private String campus;

    @Column(name = "MZSTCDIS_CANTON")
    private String canton;

    @Column(name = "MZSTCDIS_PROVINCIA")
    private String provincia;

    @OneToMany(mappedBy = "dispensario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "dispensario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Paciente> pacientes;
}
