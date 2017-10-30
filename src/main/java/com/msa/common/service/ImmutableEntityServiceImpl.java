package com.msa.common.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public class ImmutableEntityServiceImpl<T, ID extends Serializable> implements ImmutableEntityService<T, ID>,
        ReadOnlyEntityService<T, ID> {
    @Autowired
    protected CrudRepository<T, ID>   repository;

    /**
     * Add domain entity
     *
     * @param entity
     * @return
     */
    @Override
    public T add(T entity) {
        return repository.save(entity);
    }

    /**
     * Get all lists
     *
     * @return
     */
    @Override
    public List<T> gets() {
        return Lists.newArrayList(repository.findAll());
    }

    /**
     * Get specified domain model data
     *
     * @param id
     * @return
     */
    @Override
    public T get(ID id) {
        return repository.findOne(id);
    }

    /**
     * Get all count
     *
     * @return
     */
    @Override
    public long count() {
        return repository.count();
    }

    /**
     * Get local repository
     * @return
     */
    protected Repository<T, ID> getRepository() {
        return repository;
    }
}
