package me.dgrachov.studyplanner.action.auth;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.struts2.action.ServletResponseAware;
import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.interceptor.AccountSessionInterceptor;
import me.dgrachov.studyplanner.util.CookieUtil;

public class LogoutAction extends AccountSessionAwareAction implements ServletResponseAware {
    private HttpServletResponse httpServletResponse;

    @Override
    public String execute() {
        CookieUtil.removeCookie(httpServletResponse, AccountSessionInterceptor.SESSION_TOKEN_COOKIE_KEY);

        return SUCCESS;
    }

    @Override
    public void withServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }
}
