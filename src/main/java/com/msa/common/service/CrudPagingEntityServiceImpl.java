package com.msa.common.service;

import java.io.Serializable;

public class CrudPagingEntityServiceImpl<T, ID extends Serializable> extends ImmutablePagingEntityServiceImpl<T, ID>
        implements CrudPagingEntityService<T, ID> {
    /**
     * Update specified domain entity
     *
     * @param id
     * @param entity
     * @return
     */
    @Override
    public T update(ID id, T entity) {
        return repository.save(entity);
    }

    /**
     * Delete domain entity with specified id
     *
     * @param id
     */
    @Override
    public void delete(ID id) {
        repository.delete(id);
    }
}
