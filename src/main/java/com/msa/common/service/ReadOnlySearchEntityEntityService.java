package com.msa.common.service;

import java.util.List;
import java.util.Map;

public interface ReadOnlySearchEntityEntityService<T, ID> extends ReadOnlyEntityService {
    /**
     * Get all lists with specified search condition
     * @return
     */
    public List<T>  gets(Map<String, Object> condition);

    /**
     * Get specified domain model data
     * @param condition
     * @return
     */
    public T get(Map<String, Object> condition);

    /**
     * Get all count with specified search condition
     * @return
     */
    public long count(Map<String, Object> condition);
}
