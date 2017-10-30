package com.msa.common.service;

public interface CrudEntityService<T, ID> extends EditableEntityService<T, ID>,
        DeletableEntityService<ID>, ReadOnlyEntityService<T, ID> {
}
