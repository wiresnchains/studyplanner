package me.dgrachov.studyplanner.exception.auth;

import me.dgrachov.studyplanner.exception.ServiceException;

public class EmptyFieldsException extends ServiceException {
    public EmptyFieldsException(String message) {
        super(message);
    }
}
