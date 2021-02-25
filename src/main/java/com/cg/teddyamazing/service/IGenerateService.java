package com.cg.teddyamazing.service;

import java.util.Optional;

public interface IGenerateService<T, I>{
    Iterable<T> findAll();
    T save(T model);
    void delete(T model);
    Optional<T> findById(I id);
}
