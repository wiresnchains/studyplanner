package me.dgrachov.studyplanner.action.checklist;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.ChecklistDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class EditChecklistAction extends AccountSessionAwareAction {
	
	private ChecklistDTO checklist;
	
	private Boolean showPage = false;
	
	private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

	public String execute() {
		if (showPage) {
            return "showPage";
        }
		
		serviceProvider.getChecklistService().editChecklist(checklist);
		
		return SUCCESS;
	}
	
	@StrutsParameter(depth = 1)
    public ChecklistDTO getChecklist() {
        return checklist;
    }
	
	@StrutsParameter(depth = 1)
    public void setChecklist(ChecklistDTO checklist) {
        this.checklist = checklist;
    }
	
	@StrutsParameter
    public void setShowPage(Boolean showPage) {
        this.showPage = showPage;
    }
}
