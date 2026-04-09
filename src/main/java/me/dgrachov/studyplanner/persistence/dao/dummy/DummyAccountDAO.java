package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.persistence.dao.AccountDAO;

import java.util.Optional;

public class DummyAccountDAO extends DummyGenericDAO<Account, Long> implements AccountDAO {
    public DummyAccountDAO() {
        super(Account::getId);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        Optional<Account> accountOptional = Optional.empty();

        for (var entity : entities) {
            if (entity.getUsername().equals(username)) {
                accountOptional = Optional.of(entity);
                break;
            }
        }

        return accountOptional;
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        Optional<Account> accountOptional = Optional.empty();

        for (var entity : entities) {
            if (entity.getEmail().equals(email)) {
                accountOptional = Optional.of(entity);
                break;
            }
        }

        return accountOptional;
    }

    @Override
    public Optional<Account> findByEmailOrUsername(String email, String username) {
        Optional<Account> accountOptional = Optional.empty();

        for (var entity : entities) {
            if (entity.getEmail().equals(email) || entity.getUsername().equals(username)) {
                accountOptional = Optional.of(entity);
                break;
            }
        }

        return accountOptional;
    }
}
