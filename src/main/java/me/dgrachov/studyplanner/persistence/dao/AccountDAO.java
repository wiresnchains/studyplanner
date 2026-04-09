package me.dgrachov.studyplanner.persistence.dao;

import me.dgrachov.studyplanner.model.Account;

import java.util.Optional;

public interface AccountDAO extends GenericDAO<Account, Long> {
    Optional<Account> findByEmail(String email);

    Optional<Account> findByUsername(String username);

    Optional<Account> findByEmailOrUsername(String email, String username);
}
