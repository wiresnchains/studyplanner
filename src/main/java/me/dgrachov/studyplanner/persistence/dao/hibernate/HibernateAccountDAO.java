package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.persistence.dao.AccountDAO;

import java.util.Optional;

public class HibernateAccountDAO extends HibernateGenericDAO<Account, Long> implements AccountDAO {
    public HibernateAccountDAO() {
        super(Account.class);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        var query = getSession().createQuery(
                "FROM " + persistentClass.getName() + " a WHERE a.username = :username",
                persistentClass);

        query.setParameter("username", username);

        return query.uniqueResultOptional();
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        var query = getSession().createQuery(
                "FROM " + persistentClass.getName() + " a WHERE a.email = :email",
                persistentClass);

        query.setParameter("email", email);

        return query.uniqueResultOptional();
    }

    @Override
    public Optional<Account> findByEmailOrUsername(String email, String username) {
        var query = getSession().createQuery(
                "FROM " + persistentClass.getName() + " a WHERE a.email = :email OR a.username = :username",
                persistentClass);

        query.setParameter("email", email);
        query.setParameter("username", username);

        return query.uniqueResultOptional();
    }
}
