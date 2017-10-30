package com.msa.common.service;

public interface ImmutableEntityService<T, ID> {
    /**
     * Add domain entity
     * @param entity
     * @return
     */
    public T add(T entity);
}
