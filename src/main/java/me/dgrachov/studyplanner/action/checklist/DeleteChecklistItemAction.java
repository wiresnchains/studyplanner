package me.dgrachov.studyplanner.action.checklist;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.form.DeleteChecklistItemForm;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class DeleteChecklistItemAction extends AccountSessionAwareAction {
	
	private DeleteChecklistItemForm form;
	
	private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

	public String execute() {
		serviceProvider.getChecklistService().deleteChecklistItem(form.getChecklistItemId());
		return SUCCESS;
	}
	
	@StrutsParameter(depth = 1)
    public DeleteChecklistItemForm getForm() {
        return form;
    }

    @StrutsParameter(depth = 1)
    public void setForm(DeleteChecklistItemForm form) {
        this.form = form;
    }
}
