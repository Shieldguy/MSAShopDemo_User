package com.msa.common.service;

public interface EditableEntityService<T, ID> extends ImmutableEntityService<T, ID> {
    /**
     * Update specified domain entity
     * @param id
     * @param entity
     * @return
     */
    public T update(ID id, T entity);
}
