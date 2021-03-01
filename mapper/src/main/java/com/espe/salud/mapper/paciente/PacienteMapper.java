package com.espe.salud.mapper.paciente;

import com.espe.salud.banner.model.PersonaBanner;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.paciente.ContactoEmergenciaDTO;
import com.espe.salud.dto.paciente.PacienteBannerDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.dto.paciente.PacienteExternoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ContactoMapper.class, ContactoEmergenciaMapper.class, EmpleadoMapper.class, EstudianteMapper.class})
public interface PacienteMapper {

    @Mapping(source = "codigo", target = "id")
    PacienteDTO toPacienteDTO(Paciente paciente);

    @Mapping(source = "codigo", target = "id")
    @Mapping(source = "persona.apellidoPaterno", target = "apellidoPaterno")
    @Mapping(source = "persona.apellidoMaterno", target = "apellidoMaterno")
    @Mapping(source = "persona.primerNombre", target = "primerNombre")
    @Mapping(source = "persona.segundoNombre", target = "segundoNombre")
    @Mapping(source = "persona.cedula", target = "cedula")
    @Mapping(source = "persona.fechaNacimiento", target = "fechaNacimiento", qualifiedByName = "generateFechaNacimiento")
    @Mapping(source = "persona.sexo", target = "sexo")
    @Mapping(source = "persona.estadoCivil", target = "estadoCivil")
    @Mapping(source = "persona.religion", target = "religion")
    @Mapping(source = "persona.grupoSanguineo", target = "grupoSanguineo")
    @Mapping(source = "persona.instruccion", target = "instruccion")
    @Mapping(source = "persona.profesion", target = "profesion")
    @Mapping(source = "persona.vinculadoEspe", target = "vinculadoEspe")
    @Mapping(source = "persona.pueblos", target = "pueblos")
    @Mapping(source = "persona.etnia", target = "etnia")
    @Mapping(source = "persona.seguroSalud", target = "seguroSalud")
    @Mapping(source = "persona.asociacionAfiliada", target = "asociacionAfiliada")
    @Mapping(source = "persona.paisNacimiento", target = "paisNacimiento")
    @Mapping(source = "persona.provinciaNacimiento", target = "provinciaNacimiento")
    @Mapping(source = "persona.cantonNacimiento", target = "cantonNacimiento")
    @Mapping(source = "persona.nacionalidad", target = "nacionalidad")
    @Mapping(source = "persona.nacionalidad2", target = "nacionalidad2")
    @Mapping(source = "persona.contacto", target = "contacto")
    @Mapping(source = "persona.contactosEmergencia", target = "contactosEmergencia")
    PacienteDTO fromExternalPacienteToPacienteDTO(Paciente paciente);

    @Named("generateFechaNacimiento")
    static LocalDateTime generateFechaNacimiento(LocalDate fechaNacimiento) {
        return fechaNacimiento.atStartOfDay();
    }

    @Mapping(source = "paciente.codigo", target = "id")
    @Mapping(source = "paciente.nombreCompleto", target = "nombreCompleto")
    @Mapping(source = "banner.nombres", target = "primerNombre", qualifiedByName = "generateFirstPart")
    @Mapping(source = "banner.nombres", target = "segundoNombre", qualifiedByName = "generateSecondPart")
    @Mapping(source = "banner.apellidos", target = "apellidoPaterno", qualifiedByName = "generateFirstPart")
    @Mapping(source = "banner.apellidos", target = "apellidoMaterno", qualifiedByName = "generateSecondPart")
    @Mapping(source = "banner.cedula", target = "cedula")
    @Mapping(source = "banner.fechaNacimiento", target = "fechaNacimiento", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "banner.sexo", target = "sexo")
    @Mapping(source = "banner.estadoCivil", target = "estadoCivil")
    @Mapping(source = "banner.religion", target = "religion")
    @Mapping(source = "banner.grupoSanguineo", target = "grupoSanguineo")
    @Mapping(source = "banner.plurinacionalidad", target = "pueblos")
    @Mapping(source = "banner.identificacionEtnia", target = "etnia")
    @Mapping(source = "banner.paisNacimiento", target = "paisNacimiento")
    @Mapping(source = "banner.provinciaNacimiento", target = "provinciaNacimiento")
    @Mapping(source = "banner.cantonNacimiento", target = "cantonNacimiento")
    @Mapping(source = "banner.nacionalidad", target = "nacionalidad")
    @Mapping(source = "banner.callePrincipal", target = "contacto.callePrincipal")
    @Mapping(source = "banner.calleSecundaria", target = "contacto.calleSecundaria")
    @Mapping(source = "banner.referencia", target = "contacto.direccionReferencia")
    @Mapping(source = "banner.celular", target = "contacto.numeroCelular")
    @Mapping(source = "banner.telefono", target = "contacto.numeroConvencional")
    @Mapping(source = "banner.extension", target = "contacto.extension")
    @Mapping(source = "banner.correoPersonal", target = "contacto.correoPersonal")
    @Mapping(source = "banner.correoInstitucional", target = "contacto.correoInstitucional")
    @Mapping(source = "banner.parroquiaResidencia", target = "contacto.parroquiaResidencia")
    @Mapping(source = "banner.cantonResidencia", target = "contacto.cantonResidencia")
    @Mapping(source = "banner.provinciaResidencia", target = "contacto.provinciaResidencia")
    @Mapping(source = "banner.tipoParroquia", target = "contacto.zonaGeografica")
    @Mapping(source = "banner.status", target = "status")
    @Mapping(source = "banner.fechaIngresoESPE", target = "estudiante.fechaIngresoEspe", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "banner.programa", target = "estudiante.carrera")
    @Mapping(source = "banner.nivel", target = "estudiante.nivel")
    @Mapping(source = "banner.campus", target = "empleado.campus")
    @Mapping(source = "banner.fechaIngresoESPE", target = "empleado.fechaIngresoLaboral", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "banner.seccion", target = "empleado.seccion")
    @Mapping(source = "banner.departamento", target = "empleado.departamento")
    @Mapping(source = "banner.cantonCampus", target = "empleado.cantonTrabajo")
    @Mapping(source = "banner.provinciaCampus", target = "empleado.provinciaTrabajo")
    @Mapping(source = "banner.direccionCampus", target = "empleado.direccionLaboral")
    @Mapping(source = "banner.puesto", target = "empleado.cargoTrabajoActual")
    @Mapping(source = "banner.tipoEmpleado", target = "empleado.areaTrabajo")
    @Mapping(source = "banner", target = "contactosEmergencia", qualifiedByName = "generatUniqueContactoEmergencia")
    PacienteDTO fromPacienteAndPersonaBannerToPacienteDTO(Paciente paciente, PersonaBanner banner);

    @Named("generateFirstPart")
    static String generateFirstPart(String nombresOrApellidos) {
        int idx = nombresOrApellidos.lastIndexOf(' ');
        if (idx == -1) {
            return nombresOrApellidos;
        }
        return nombresOrApellidos.substring(0, idx);
    }

    @Named("generateSecondPart")
    static String generateSecondPart(String nombresOrApellidos) {
        int idx = nombresOrApellidos.lastIndexOf(' ');
        if (idx == -1) {
            return "";
        }
        return nombresOrApellidos.substring(idx + 1);
    }

    @Named("generatUniqueContactoEmergencia")
    static List<ContactoEmergenciaDTO> generateContactosEmergencia(PersonaBanner personaBanner) {
        if (personaBanner.getContactoEmergenciaNombre() != null) {
            List<ContactoEmergenciaDTO> contactos = new ArrayList<>();
            ContactoEmergenciaDTO contacto = new ContactoEmergenciaDTO();
            contacto.setNombreContacto(personaBanner.getContactoEmergenciaNombre());
            contacto.setDireccion(personaBanner.getContactoEmergenciaDireccion());
            contacto.setTelefonoConvencional(personaBanner.getContactoEmergenciaTelefono());
            contacto.setTelefonoCelular(personaBanner.getContactoEmergenciaCelular());
            contacto.setParentesco(personaBanner.getContactoEmergenciaParentesco());
            contactos.add(contacto);
            return contactos;
        }
        return new ArrayList<>();
    }

    Paciente fromPacienteBannerDTOToPaciente(PacienteBannerDTO pacienteBannerDTO);

    @Mapping(source = "apellidoPaterno", target = "persona.apellidoPaterno")
    @Mapping(source = "apellidoMaterno", target = "persona.apellidoMaterno")
    @Mapping(source = "primerNombre", target = "persona.primerNombre")
    @Mapping(source = "segundoNombre", target = "persona.segundoNombre")
    @Mapping(source = "cedula", target = "persona.cedula")
    @Mapping(source = "fechaNacimiento", target = "persona.fechaNacimiento")
    @Mapping(source = "sexo", target = "persona.sexo")
    @Mapping(source = "estadoCivil", target = "persona.estadoCivil")
    @Mapping(source = "religion", target = "persona.religion")
    @Mapping(source = "grupoSanguineo", target = "persona.grupoSanguineo")
    @Mapping(source = "instruccion", target = "persona.instruccion")
    @Mapping(source = "profesion", target = "persona.profesion")
    @Mapping(source = "vinculadoEspe", target = "persona.vinculadoEspe")
    @Mapping(source = "pueblos", target = "persona.pueblos")
    @Mapping(source = "etnia", target = "persona.etnia")
    @Mapping(source = "seguroSalud", target = "persona.seguroSalud")
    @Mapping(source = "asociacionAfiliada", target = "persona.asociacionAfiliada")
    @Mapping(source = "paisNacimiento", target = "persona.paisNacimiento")
    @Mapping(source = "provinciaNacimiento", target = "persona.provinciaNacimiento")
    @Mapping(source = "cantonNacimiento", target = "persona.cantonNacimiento")
    @Mapping(source = "nacionalidad", target = "persona.nacionalidad")
    @Mapping(source = "nacionalidad2", target = "persona.nacionalidad2")
    @Mapping(source = "contacto", target = "persona.contacto")
    @Mapping(source = "contactosEmergencia", target = "persona.contactosEmergencia")
    Paciente fromPacienteExternoDTOToPaciente(PacienteExternoDTO pacienteExternoDTO);
}