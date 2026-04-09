package me.dgrachov.studyplanner.exception.auth;

import me.dgrachov.studyplanner.exception.ServiceException;

public class CredentialsTakenException extends ServiceException {
    public CredentialsTakenException(String message) {
        super(message);
    }
}
