package me.dgrachov.studyplanner.interceptor;

import org.apache.struts2.ActionInvocation;
import org.apache.struts2.action.Action;
import org.apache.struts2.interceptor.AbstractInterceptor;

import me.dgrachov.studyplanner.model.Account;

public class RequireLoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        var session = invocation.getInvocationContext().getSession();
        var account = (Account) session.get(AccountSessionInterceptor.CURRENT_ACCOUNT_SESSION_KEY);

        if (account == null) {
            return Action.LOGIN;
        } else {
            return invocation.invoke();
        }
    }
}
