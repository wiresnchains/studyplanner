package me.dgrachov.studyplanner.action.subject;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.form.DeleteSubjectForm;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class DeleteSubjectAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private DeleteSubjectForm form;

    @Override
    public String execute() {
        serviceProvider.getSubjectService().deleteSubject(form.getSubjectId());
        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public DeleteSubjectForm getForm() {
        return form;
    }

    @StrutsParameter(depth = 1)
    public void setForm(DeleteSubjectForm form) {
        this.form = form;
    }
}
