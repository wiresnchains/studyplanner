package me.dgrachov.studyplanner.action.checklist;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.form.CreateChecklistItemForm;
import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class CreateChecklistItemAction extends AccountSessionAwareAction {
	
	private CreateChecklistItemForm form;
	
	private Checklist checklist;
	
	private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

	public String execute() {
		
		serviceProvider.getChecklistService().createChecklistItem(checklist, form.getName());
		
		return SUCCESS;
	}
	
	@StrutsParameter(depth = 1)
    public CreateChecklistItemForm getForm() {
        return form;
    }
	
	@StrutsParameter(depth = 1)
    public void setForm(CreateChecklistItemForm form) {
        this.form = form;
    }
	
	@StrutsParameter(depth = 1)
    public Checklist getChecklist() {
        return checklist;
    }
	
	@StrutsParameter(depth = 1)
    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }
	
}
