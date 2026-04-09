package me.dgrachov.studyplanner.persistence.dao.hibernate;

import org.hibernate.Session;
import me.dgrachov.studyplanner.persistence.HibernateSessionManager;
import me.dgrachov.studyplanner.persistence.dao.GenericDAO;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class HibernateGenericDAO<E, ID extends Serializable> implements GenericDAO<E, ID> {
    protected final Class<E> persistentClass;

    public HibernateGenericDAO(Class<E> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public List<E> findAll() {
        return getSession().createQuery("from " + persistentClass.getName(), persistentClass).getResultList();
    }

    @Override
    public Optional<E> findById(ID id) {
        E entity = getSession().find(persistentClass, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public void persist(E entity) {
        getSession().persist(entity);
    }

    @Override
    public void merge(E entity) {
        getSession().merge(entity);
    }

    @Override
    public void remove(E entity) {
        getSession().remove(entity);
    }

    protected Session getSession() {
        return HibernateSessionManager.getSessionFactory().getCurrentSession();
    }
}
