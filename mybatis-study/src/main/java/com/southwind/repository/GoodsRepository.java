package com.southwind.repository;

import com.southwind.entity.Goods;

public interface GoodsRepository {
    public Goods findById(long id);
}
