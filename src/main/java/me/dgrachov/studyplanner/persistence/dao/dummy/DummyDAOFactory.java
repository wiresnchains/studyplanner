package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

public class DummyDAOFactory extends DAOFactory {
    private final DummyAccountDAO accountDAO = new DummyAccountDAO();
    private final DummyAccountMessageDAO accountMessageDAO = new DummyAccountMessageDAO();

    @Override
    public DummyAccountDAO getAccountDAO() {
        return accountDAO;
    }

    @Override
    public DummyAccountMessageDAO getAccountMessageDAO() {
        return accountMessageDAO;
    }
}
