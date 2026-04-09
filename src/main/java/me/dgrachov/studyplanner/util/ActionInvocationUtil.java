package me.dgrachov.studyplanner.util;

import org.apache.struts2.ActionInvocation;
import org.apache.struts2.interceptor.ValidationAware;

public class ActionInvocationUtil {
    public static void addActionMessage(ActionInvocation invocation, String message) {
        var action = invocation.getAction();
        if (action instanceof ValidationAware) {
            ((ValidationAware) action).addActionMessage(message);
        }
    }

    public static void addActionError(ActionInvocation invocation, String error) {
        var action = invocation.getAction();
        if (action instanceof ValidationAware) {
            ((ValidationAware) action).addActionError(error);
        }
    }
}
