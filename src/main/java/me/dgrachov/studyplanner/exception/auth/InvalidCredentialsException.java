package me.dgrachov.studyplanner.exception.auth;

import me.dgrachov.studyplanner.exception.ServiceException;

public class InvalidCredentialsException extends ServiceException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
