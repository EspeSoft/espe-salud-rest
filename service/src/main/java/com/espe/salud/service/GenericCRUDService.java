package com.espe.salud.service;

import java.util.List;
import java.util.Optional;

public interface GenericCRUDService<DOMAIN, DTO> {

    public DTO saveOrUpdate(DTO dtoObject);

    public List<DTO> findAll(DTO dtoObject);

    public DTO findById(Long id);

    /**
     * Permite mapear un objeto serializable a un objeto de dominio
     *
     * @param dtoObject
     * @return
     */
    public DOMAIN mapTo(DTO dtoObject);

    /**
     * Permite serializar un objeto de dominio
     *
     * @param domainObject
     * @return
     */
    public DTO build(DOMAIN domainObject);

    /**
     * Permite encontrar un objeto existente con la misma clave primaria
     *
     * @param domainObject
     * @return
     */
    public abstract Optional<DOMAIN> findExisting(DTO domainObject);

    public abstract List<DTO> findAllOrderByNameASC();

    public abstract boolean delete(Long id);
}