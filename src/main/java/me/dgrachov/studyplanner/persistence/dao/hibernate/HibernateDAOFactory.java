package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

public class HibernateDAOFactory extends DAOFactory {
    private final HibernateAccountDAO accountDAO = new HibernateAccountDAO();
    private final HibernateAccountMessageDAO accountMessageDAO = new HibernateAccountMessageDAO();

    @Override
    public HibernateAccountDAO getAccountDAO() {
        return accountDAO;
    }

    @Override
    public HibernateAccountMessageDAO getAccountMessageDAO() {
        return accountMessageDAO;
    }
}
