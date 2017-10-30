package com.msa.common.service;

import java.util.List;

public interface ReadOnlyEntityService<T, ID> {
    /**
     * Get all lists
     * @return
     */
    public List<T>  gets();

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
