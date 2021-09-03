package com.southwind.repository;

import com.southwind.entity.Student;

public interface StudentRepository {
    public Student findById(long id);
    public Student findByIdLazy(long id);
}
