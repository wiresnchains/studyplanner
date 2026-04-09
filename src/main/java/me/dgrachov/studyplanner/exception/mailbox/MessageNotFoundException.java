package me.dgrachov.studyplanner.exception.mailbox;

import me.dgrachov.studyplanner.exception.ServiceException;

public class MessageNotFoundException extends ServiceException {
    public MessageNotFoundException(String message) {
        super(message);
    }
}
