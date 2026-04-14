package me.dgrachov.studyplanner.action.checklist;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.ChecklistDTO;
import me.dgrachov.studyplanner.form.DeleteChecklistForm;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class DeleteChecklistAction extends AccountSessionAwareAction {
	
	private DeleteChecklistForm form;
	
	private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

	public String execute() {
		serviceProvider.getChecklistService().deleteChecklist(form.getChecklistId());
		return SUCCESS;
	}
	
	@StrutsParameter(depth = 1)
    public DeleteChecklistForm getForm() {
        return form;
    }

    @StrutsParameter(depth = 1)
    public void setForm(DeleteChecklistForm form) {
        this.form = form;
    }
}
