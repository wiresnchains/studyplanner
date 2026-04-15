package me.dgrachov.studyplanner.action.checklist;

import java.util.List;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class ShowChecklistItemAction extends AccountSessionAwareAction {
	
	private List<Checklist> checklists;
	
	private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

	public String execute() {
		checklists = serviceProvider.getChecklistService().show(account);
		return SUCCESS;
	}
	
	@StrutsParameter(depth = 1)
    public List<Checklist> getChecklists() {
        return checklists;
    }
	
	@StrutsParameter(depth = 1)
    public void setChecklists(List<Checklist> checklists) {
        this.checklists = checklists;
    }
}
