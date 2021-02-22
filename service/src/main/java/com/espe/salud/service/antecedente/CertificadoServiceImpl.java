package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.Certificado;
import com.espe.salud.dto.antecedente.CertificadoDTO;
import com.espe.salud.mapper.antecedente.CertificadoMapper;
import com.espe.salud.persistence.antecedente.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificadoServiceImpl implements CertificadoService{
    private final CertificadoRepository certificadoRepository;
    private final CertificadoMapper mapper;

    @Autowired
    public CertificadoServiceImpl(CertificadoRepository certificadoRepository, CertificadoMapper mapper) {
        this.certificadoRepository = certificadoRepository;
        this.mapper = mapper;
    }

    @Override
    public CertificadoDTO save(CertificadoDTO certificadoDTO) {
        Optional<Certificado> optional=certificadoRepository.findById(certificadoDTO.getId());
        if (optional.isPresent()){
            Certificado domainObject=toEntity(certificadoDTO);
            return toDTO(certificadoRepository.save(domainObject));
        }else {
            throw  new ConflictException(String.format("Ya existe un certificado para el codigo [%s]",certificadoDTO.getId()));
        }
    }

    @Override
    public CertificadoDTO update(CertificadoDTO certificadoDTO) {
        Certificado domainObject=toEntity(certificadoDTO);
        return toDTO(certificadoRepository.save(domainObject));
    }

    @Override
    public Optional<CertificadoDTO> findById(Long codigo) {
       return certificadoRepository.findByCodigo(codigo).map(certificado -> toDTO(certificado));
    }

    @Override
    public List<CertificadoDTO> findAll() {
        return mapper.toCertificadoDTO(certificadoRepository.findAll());
    }

    @Override
    public boolean deleteById(Long id) {
        return certificadoRepository.findByCodigo(id).map(certificado -> {
                    certificadoRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }

    @Override
    public CertificadoDTO toDTO(Certificado certificado) {
        return mapper.toCertificadoDTO(certificado);
    }

    @Override
    public Certificado toEntity(CertificadoDTO dto) {
        return mapper.toCertificado(dto);
    }
}
