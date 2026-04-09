package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.model.AccountMessage;
import me.dgrachov.studyplanner.persistence.dao.AccountMessageDAO;

public class DummyAccountMessageDAO extends DummyGenericDAO<AccountMessage, Long> implements AccountMessageDAO {
    public DummyAccountMessageDAO() {
        super(AccountMessage::getId);
    }
}
