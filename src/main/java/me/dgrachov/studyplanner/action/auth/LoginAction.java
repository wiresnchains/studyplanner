package me.dgrachov.studyplanner.action.auth;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.struts2.action.ServletResponseAware;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.form.LoginForm;
import me.dgrachov.studyplanner.interceptor.AccountSessionInterceptor;
import me.dgrachov.studyplanner.service.ServiceProvider;
import me.dgrachov.studyplanner.util.CookieUtil;

import java.time.Duration;

public class LoginAction extends AccountSessionAwareAction implements ServletResponseAware {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private HttpServletResponse httpServletResponse;

    private LoginForm form;

    @Override
    public String execute() {
        var sessionToken = serviceProvider.getAuthService().login(form);

        CookieUtil.setCookie(httpServletResponse, AccountSessionInterceptor.SESSION_TOKEN_COOKIE_KEY,
                sessionToken, Duration.ofDays(7));

        return SUCCESS;
    }

    @Override
    public void withServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @StrutsParameter(depth = 1)
    public LoginForm getForm() {
        return form;
    }

    @StrutsParameter(depth = 1)
    public void setForm(LoginForm form) {
        this.form = form;
    }
}
