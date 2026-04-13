package me.dgrachov.studyplanner.action.subject;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.form.CreateSubjectForm;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class CreateSubjectAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private CreateSubjectForm form;
    private Boolean showPage;

    @Override
    public String execute() {
        if (showPage) {
            return "showPage";
        }

        serviceProvider.getSubjectService().createSubject(form.getName(), account);

        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public CreateSubjectForm getForm() {
        return form;
    }

    @StrutsParameter(depth = 1)
    public void setForm(CreateSubjectForm form) {
        this.form = form;
    }

    @StrutsParameter
    public void setShowPage(Boolean showPage) {
        this.showPage = showPage;
    }
}
