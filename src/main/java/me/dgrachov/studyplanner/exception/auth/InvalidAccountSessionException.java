package me.dgrachov.studyplanner.exception.auth;

import me.dgrachov.studyplanner.exception.ServiceException;

public class InvalidAccountSessionException extends ServiceException {
    public InvalidAccountSessionException(String message) {
        super(message);
    }
}
