package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Reposo;
import com.espe.salud.dto.evolucion.ReposoDTO;
import com.espe.salud.mapper.evolucion.ReposoMapper;
import com.espe.salud.persistence.evolucion.ReposoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReposoServiceImpl implements ReposoService{
    private final ReposoRepository repository;
    private final ReposoMapper mapper;

    @Autowired
    public ReposoServiceImpl(ReposoRepository repository, ReposoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ReposoDTO save(ReposoDTO dto) {
        Optional<Reposo> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            Reposo domainObject = toEntity(dto);
            return toDTO(repository.save(domainObject));
        }else {
            throw new ConflictException(String.format("Ya existe un reposo registrado para ese código[%s]", dto.getId()));
        }
    }

    @Override
    public ReposoDTO update(ReposoDTO dto) {
        return null;
    }

    @Override
    public Optional<Reposo> findExisting(ReposoDTO dto) {
        return repository.findByCodigo(dto.getId());
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Optional<ReposoDTO> findById(Long id) {
       return repository.findByCodigo(id).map(this::toDTO);
    }

    @Override
    public ReposoDTO toDTO(Reposo reposo) {
        return mapper.toReposoDTO(reposo);
    }

    @Override
    public Reposo toEntity(ReposoDTO dto) {
        return mapper.toReposo(dto);
    }

    @Override
    public List<ReposoDTO> findAll() {
        return null;
    }
}
