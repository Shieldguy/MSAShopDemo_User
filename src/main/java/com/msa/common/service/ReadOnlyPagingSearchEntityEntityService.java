package com.msa.common.service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ReadOnlyPagingSearchEntityEntityService<T, ID> extends ReadOnlyPagingEntityService {
    /**
     * Get all data with specified page and search condition
     * @param pageable
     * @return
     */
    public List<T> gets(Map<String, Object> condition, Pageable pageable);

    /**
     * Get specified domain model data
     * @param condition
     * @return
     */
    public T get(Map<String, Object> condition);

    /**
     * Get all count with search condition
     * @return
     */
    public long count(Map<String, Object> condition);
}
