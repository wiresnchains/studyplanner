package me.dgrachov.studyplanner.persistence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<E, ID extends Serializable> {
    List<E> findAll();

    Optional<E> findById(ID id);

    void persist(E entity);

    void merge(E entity);

    void remove(E entity);
}
