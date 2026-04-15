package me.dgrachov.studyplanner.action.task;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.form.DeleteTaskForm;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class DeleteTaskAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private DeleteTaskForm form;

    @Override
    public String execute() {
        serviceProvider.getTaskService().delete(form.getTaskId());
        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public DeleteTaskForm getForm() {
        return form;
    }

    @StrutsParameter(depth = 1)
    public void setForm(DeleteTaskForm form) {
        this.form = form;
    }
}
