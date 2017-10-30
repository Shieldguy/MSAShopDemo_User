package com.msa.common.service;

public interface DeletableEntityService<ID> {
    /**
     * Delete domain entity with specified id
     * @param id
     */
    public void delete(ID id);
}
