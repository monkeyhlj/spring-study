package com.southwind.repository;

import com.southwind.entity.Customer;

public interface CustomerRepository {
    public Customer findById(long id);
}
