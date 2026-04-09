package me.dgrachov.studyplanner.action.auth;

import org.apache.struts2.interceptor.parameter.StrutsParameter;
import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.form.RegisterForm;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class RegisterAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private RegisterForm form;

    @Override
    public String execute() {
        serviceProvider.getAuthService().register(form);

        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public RegisterForm getForm() {
        return form;
    }

    @StrutsParameter(depth = 1)
    public void setForm(RegisterForm form) {
        this.form = form;
    }
}
