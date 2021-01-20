package com.salud.espe.service;

import java.util.List;
import java.util.Optional;

public interface GenericCRUDService<DOMAIN, DTO> {

    public void saveOrUpdate(DTO dtoObject);

    public List<DTO> findAll(DTO dtoObject);

    /**
     * Permite mapear un objeto serializable a un objeto de dominio
     * @param dtoObject
     * @return
     */
    public DOMAIN mapTo(DTO dtoObject);

    /**
     * Permite serializar un objeto de dominio
     * @param domainObject
     * @return
     */
    public DTO build(DOMAIN domainObject);

    /**
     * Permite encontrar un objeto existente con la misma clave primaria
     * @param domainObject
     * @return
     */
    public abstract Optional<DOMAIN> findExisting(DTO domainObject);

}