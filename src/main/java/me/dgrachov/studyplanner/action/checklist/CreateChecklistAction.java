package me.dgrachov.studyplanner.action.checklist;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.form.CreateChecklistForm;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class CreateChecklistAction extends AccountSessionAwareAction {
	
	private CreateChecklistForm form;
	
	private Boolean showPage = false;
	
	private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

	public String execute() {
		if (showPage) {
            return "showPage";
        }
		
		serviceProvider.getChecklistService().createChecklist(account, form.getName());
		
		return SUCCESS;
	}
	
	@StrutsParameter(depth = 1)
    public CreateChecklistForm getForm() {
        return form;
    }
	
	@StrutsParameter(depth = 1)
    public void setForm(CreateChecklistForm form) {
        this.form = form;
    }
	
	@StrutsParameter
    public void setShowPage(Boolean showPage) {
        this.showPage = showPage;
    }
}
