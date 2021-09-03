package com.southwind.repository;

import com.southwind.entity.Classes;

public interface ClassesRepository {
    public Classes findById(long id);
    public Classes findByIdLazy(long id);
}
