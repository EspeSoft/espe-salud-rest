package com.espe.salud.mapper.paciente;

import com.espe.salud.banner.model.PersonaBanner;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.paciente.ContactoEmergenciaDTO;
import com.espe.salud.dto.paciente.PacienteBannerDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ContactoMapper.class, ContactoEmergenciaMapper.class})
public interface PacienteMapper {

    @Mapping(source = "codigo", target = "id")
    PacienteDTO toPacienteDTO(Paciente paciente);
    
    @Mapping(source = "paciente.codigo", target = "id")
    @Mapping(source = "paciente.nombreCompleto", target = "nombreCompleto")
    @Mapping(source = "banner.nombres", target = "primerNombre", qualifiedByName = "generateFirstPart")
    @Mapping(source = "banner.nombres", target = "segundoNombre", qualifiedByName = "generateSecondPart")
    @Mapping(source = "banner.apellidos", target = "apellidoPaterno", qualifiedByName = "generateFirstPart")
    @Mapping(source = "banner.apellidos", target = "apellidoMaterno", qualifiedByName = "generateSecondPart")
    @Mapping(source = "paciente.numeroArchivo", target = "cedula")
    @Mapping(source = "banner.fechaNacimiento", target = "fechaNacimiento", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "banner.sexo", target = "sexo")
    @Mapping(source = "banner.estadoCivil", target = "estadoCivil")
    @Mapping(source = "banner.religion", target = "religion")
    @Mapping(source = "banner.grupoSanguineo", target = "grupoSanguineo")
    @Mapping(source = "banner.plurinacionalidad", target = "pueblos")
    @Mapping(source = "banner.identificacionEtnia", target = "grupoCultural")
    @Mapping(source = "banner.paisNacimiento", target = "paisNacimiento")
    @Mapping(source = "banner.provinciaNacimiento", target = "provinciaNacimiento")
    @Mapping(source = "banner.cantonNacimiento", target = "cantonNacimiento")
    @Mapping(source = "banner.nacionalidad", target = "nacionalidad")
    @Mapping(source = "banner.direccionCallePrincipal", target = "contacto.callePrincipal")
    @Mapping(source = "banner.direccionCalleSecundaria", target = "contacto.calleSecundaria")
    @Mapping(source = "banner.referencia", target = "contacto.direccionReferencia")
    @Mapping(source = "banner.celular", target = "contacto.numeroCelular")
    @Mapping(source = "banner.telefono", target = "contacto.numeroConvencional")
    @Mapping(source = "banner.correoPersonal", target = "contacto.correoPersonal")
    @Mapping(source = "banner.correoInstitucional", target = "contacto.correoInstitucional")
    @Mapping(source = "banner.parroquiaResidencia", target = "contacto.parroquiaResidencia")
    @Mapping(source = "banner.cantonResidencia", target = "contacto.cantonResidencia")
    @Mapping(source = "banner.provinciaResidencia", target = "contacto.provinciaResidencia")
    @Mapping(source = "banner.paisResidencia", target = "contacto.paisResidencia")
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
        if (personaBanner.getContactoEmergenciaNombre() != null || personaBanner.getContactoEmergenciaApellido() != null) {
            List<ContactoEmergenciaDTO> contactos = new ArrayList<>();
            ContactoEmergenciaDTO contacto = new ContactoEmergenciaDTO();
            contacto.setNombreContacto(personaBanner.getContactoEmergenciaNombre());
            contacto.setApellidoContacto(personaBanner.getContactoEmergenciaApellido());
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

    List<PacienteDTO> toPacientesDTO(List<Paciente> pacientes);
}