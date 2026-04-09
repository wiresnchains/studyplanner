package me.dgrachov.studyplanner.interceptor;

import org.apache.struts2.ActionInvocation;
import org.apache.struts2.action.Action;
import org.apache.struts2.interceptor.AbstractInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.dgrachov.studyplanner.exception.ServiceException;
import me.dgrachov.studyplanner.util.ActionInvocationUtil;

public class ExceptionInterceptor extends AbstractInterceptor {
    private static final Logger log = LoggerFactory.getLogger(ExceptionInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) {
        try {
            return invocation.invoke();
        } catch (ServiceException ex) {
            ActionInvocationUtil.addActionError(invocation, ex.getMessage());
            return Action.ERROR;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            ActionInvocationUtil.addActionError(invocation, "Something went wrong, please try again later.");
            return Action.ERROR;
        }
    }
}
