package com.Jeu_421.DAO;

import java.util.Collection;

import model.JpaEntity;

public interface JpaDao <T extends JpaEntity, ID> {

    T findById(ID id);

    Collection<T> findAll();

    T save(T entity);

    void delete(T entity);

    void clear();
}