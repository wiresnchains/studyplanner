package me.dgrachov.studyplanner.action.checklist;

import java.util.List;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.model.ChecklistItem;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class ShowChecklistItemAction extends AccountSessionAwareAction {
	
	private Long checklistId;
	private List<ChecklistItem> checklistItems;
	
	private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

	public String execute() {
		checklistItems = serviceProvider.getChecklistService().showItems(checklistId);
		return SUCCESS;
	}
	
	@StrutsParameter(depth = 1)
	public Long getChecklistId() {
	    return checklistId;
	}
	
	@StrutsParameter(depth = 1)
	public void setChecklistId(Long checklistId) {
	    this.checklistId = checklistId;
	}

	@StrutsParameter(depth = 1)
    public List<ChecklistItem> getChecklistItems() {
        return checklistItems;
    }
	
	@StrutsParameter(depth = 1)
    public void setChecklistItems(List<ChecklistItem> checklistItems) {
        this.checklistItems = checklistItems;
    }
}
