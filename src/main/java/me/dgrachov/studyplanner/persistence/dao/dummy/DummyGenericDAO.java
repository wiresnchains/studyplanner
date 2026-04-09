package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.persistence.dao.GenericDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DummyGenericDAO<E, ID extends Serializable> implements GenericDAO<E, ID> {
    protected final List<E> entities = new ArrayList<>();
    protected final Function<E, ID> idGetter;

    public DummyGenericDAO(Function<E, ID> idGetter) {
        this.idGetter = idGetter;
    }

    @Override
    public List<E> findAll() {
        return entities;
    }

    @Override
    public Optional<E> findById(ID id) {
        if (id == null) {
            return Optional.empty();
        }

        return entities.stream()
                .filter(e -> id.equals(idGetter.apply(e)))
                .findFirst();
    }

    @Override
    public void persist(E entity) {
        if (findById(idGetter.apply(entity)).isPresent()) {
            merge(entity);
        } else {
            entities.add(entity);
        }
    }

    @Override
    public void merge(E entity) {
        ID id = idGetter.apply(entity);
        var existingEntity = findById(id);

        if (existingEntity.isEmpty()) {
            persist(entity);
        } else {
            entities.remove(existingEntity);
            entities.add(entity);
        }
    }

    @Override
    public void remove(E entity) {
        var entityId = idGetter.apply(entity);

        if (entityId == null) {
            return;
        }

        for (int i = 0; i < entities.size(); i++) {
            var entityIterator = entities.get(i);
            var entityItId = idGetter.apply(entityIterator);

            if (!entityId.equals(entityItId)) {
                continue;
            }

            entities.remove(i);
        }
    }
}
