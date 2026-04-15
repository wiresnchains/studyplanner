package me.dgrachov.studyplanner.action.checklist;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.service.ServiceProvider;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

import java.util.List;

public class UpdateChecklistItemPositionAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private Long checklistId;
    private List<Long> itemIds;

    @Override
    public String execute() {
        serviceProvider.getChecklistService().updateItemPositions(checklistId, itemIds);
        return SUCCESS;
    }

    @StrutsParameter
    public void setChecklistId(Long checklistId) {
        this.checklistId = checklistId;
    }

    public Long getChecklistId() {
        return checklistId;
    }

    @StrutsParameter
    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }
}
