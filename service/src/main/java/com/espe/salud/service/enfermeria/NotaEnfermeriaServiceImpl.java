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
        Optional<NotaEnfermeria> optional = domainRepository.findById(notaEnfermeria.getId());
        if (!optional.isPresent()) {
            NotaEnfermeria domainObject = toEntity(notaEnfermeria);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una nota de enfermeria registrada para ese código[%s]", notaEnfermeria.getId()));
        }
    }

    @Override
    public Optional<NotaEnfermeriaDTO> findById(Long codigo) {
        return domainRepository.findById(codigo).map(notaEnfermeria -> toDTO(notaEnfermeria));
    }

    public List<NotaEnfermeriaDTO> findByPaciente(Long codigo) {
        return mapper.toNotasEnfermeriaDTO(domainRepository.findByPacienteCodigoOrderByFechaInicio(codigo));
    }

    @Override
    public NotaEnfermeriaDTO toDTO(NotaEnfermeria notaEnfermeria) {
        return mapper.toNotaEnfermeriaDTO(notaEnfermeria);
    }

    @Override
    public NotaEnfermeria toEntity(NotaEnfermeriaDTO dto) {
        return mapper.toNotaEnfermeria(dto);
    }
}
