package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.model.AccountMessage;
import me.dgrachov.studyplanner.persistence.dao.AccountMessageDAO;

public class HibernateAccountMessageDAO extends HibernateGenericDAO<AccountMessage, Long> implements AccountMessageDAO {
    public HibernateAccountMessageDAO() {
        super(AccountMessage.class);
    }
}
