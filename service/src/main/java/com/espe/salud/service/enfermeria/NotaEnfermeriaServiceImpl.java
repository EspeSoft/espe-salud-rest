package com.espe.salud.service.enfermeria;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import com.espe.salud.dto.enfermeria.NotaEnfermeriaDTO;
import com.espe.salud.mapper.enfermeria.NotaEnfermeriaMapper;
import com.espe.salud.persistence.enfermeria.NotaEnfermeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NotaEnfermeriaServiceImpl implements NotaEnfermeriaService{

    private final NotaEnfermeriaRepository domainRepository;
    private final NotaEnfermeriaMapper mapper;

    @Autowired
    public NotaEnfermeriaServiceImpl(NotaEnfermeriaRepository domainRepository,
                                     NotaEnfermeriaMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public NotaEnfermeriaDTO save(NotaEnfermeriaDTO notaEnfermeria) {
        Optional<NotaEnfermeria> optional = domainRepository.findByCodigo(notaEnfermeria.getId());
        if (optional.isEmpty()) {
            NotaEnfermeria domainObject = toEntity(notaEnfermeria);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una nota de enfermeria registrada para ese código[%s]", notaEnfermeria.getId()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NotaEnfermeriaDTO> findById(Long codigo) {
        return domainRepository.findByCodigo(codigo).map(this::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotaEnfermeriaDTO> findByPaciente(Long pacienteCodigo) {
        return mapper.toNotasEnfermeriaDTO(domainRepository.findByPacienteCodigoOrderByFechaInicio(pacienteCodigo));
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotaEnfermeriaDTO> findByUsuario(Long pidm) {
        return mapper.toNotasEnfermeriaDTO(domainRepository.findByUsuarioPidmOrderByFechaInicio(pidm));
    }

    @Override
    public NotaEnfermeriaDTO toDTO(NotaEnfermeria notaEnfermeria) {
        return mapper.toNotaEnfermeriaDTO(notaEnfermeria);
    }

    @Override
    public NotaEnfermeria toEntity(NotaEnfermeriaDTO dto) {
        return mapper.toNotaEnfermeria(dto);
    }

    @Override
    @Transactional
    public boolean delete(Long notaEnfemeriaId) {
        return domainRepository.findById(notaEnfemeriaId).map(notaEnfermeria -> {
            domainRepository.deleteById(notaEnfemeriaId);
            return true;
        }).orElse(false);
    }
}
