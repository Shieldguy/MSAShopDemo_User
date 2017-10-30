package com.msa.common.service;

public interface CrudPagingEntityService<T, ID> extends EditableEntityService<T, ID>,
        DeletableEntityService<ID>, ReadOnlyPagingEntityService<T, ID> {
}
