package com.espe.salud.service.certificado;

import com.espe.salud.domain.entities.certificado.Certificado;
import com.espe.salud.dto.certificado.CertificadoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CertificadoService {
    CertificadoDTO save(CertificadoDTO certificadoDTO);
    CertificadoDTO update(CertificadoDTO certificadoDTO);
    Optional<CertificadoDTO> findById(Long codigo);
    List<CertificadoDTO> findByPaciente(Long pacienteCodigo);
    List<CertificadoDTO> findAll();
    boolean deleteById(Long id);
    CertificadoDTO toDTO(Certificado certificado);
    Certificado toEntity(CertificadoDTO dto);
}
