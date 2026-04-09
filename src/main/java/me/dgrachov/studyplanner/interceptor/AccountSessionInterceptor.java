package me.dgrachov.studyplanner.interceptor;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.struts2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.AbstractInterceptor;
import me.dgrachov.studyplanner.exception.auth.InvalidAccountSessionException;
import me.dgrachov.studyplanner.mapper.MapperProvider;
import me.dgrachov.studyplanner.service.ServiceProvider;
import me.dgrachov.studyplanner.util.ActionInvocationUtil;
import me.dgrachov.studyplanner.util.CookieUtil;

public class AccountSessionInterceptor extends AbstractInterceptor {
    public static final String CURRENT_ACCOUNT_SESSION_KEY = "currentAccount";
    public static final String CURRENT_ACCOUNT_DTO_SESSION_KEY = "currentAccountDTO";
    public static final String SESSION_TOKEN_COOKIE_KEY = "sessionToken";

    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private static final MapperProvider mapperProvider = MapperProvider.getInstance();

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        var request = ServletActionContext.getRequest();
        var response = ServletActionContext.getResponse();
        var session = invocation.getInvocationContext().getSession();

        var sessionToken = CookieUtil.getCookie(request, SESSION_TOKEN_COOKIE_KEY);

        try {
            if (sessionToken != null) {
                var account = serviceProvider.getAuthService().findAccountFromSession(sessionToken);
                var accountDTO = mapperProvider.getAccountMapper().toDTO(account);

                session.put(CURRENT_ACCOUNT_SESSION_KEY, account);
                session.put(CURRENT_ACCOUNT_DTO_SESSION_KEY, accountDTO);
            }
        } catch (InvalidAccountSessionException ex) {
            ActionInvocationUtil.addActionMessage(invocation, "Your account session has expired");
            clearAccountSession(invocation, response);
        }

        try {
            return invocation.invoke();
        } catch (Exception e) {
            throw e;
        } finally {
            session.remove(CURRENT_ACCOUNT_SESSION_KEY);
            session.remove(CURRENT_ACCOUNT_DTO_SESSION_KEY);
        }
    }

    private void clearAccountSession(ActionInvocation invocation, HttpServletResponse response) {
        var session = invocation.getInvocationContext().getSession();

        CookieUtil.removeCookie(response, SESSION_TOKEN_COOKIE_KEY);

        session.remove(CURRENT_ACCOUNT_SESSION_KEY);
        session.remove(CURRENT_ACCOUNT_DTO_SESSION_KEY);
    }
}
