package com.msa.common.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReadOnlyPagingEntityService<T, ID> {
    /**
     * Get all data with specified page
     * @param pageable
     * @return
     */
    public List<T> gets(Pageable pageable);

    /**
     * Get specified domain model data
     * @param id
     * @return
     */
    public T get(ID id);

    /**
     * Get all count
     * @return
     */
    public long count();
}
