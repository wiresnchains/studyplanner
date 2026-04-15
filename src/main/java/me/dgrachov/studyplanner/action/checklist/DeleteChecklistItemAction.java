package me.dgrachov.studyplanner.action.checklist;

import org.apache.struts2.interceptor.parameter.StrutsParameter;
import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.ChecklistItemDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class DeleteChecklistItemAction extends AccountSessionAwareAction {

    private ChecklistItemDTO form = new ChecklistItemDTO();
    private Long checklistId;

    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    public String execute() {
        serviceProvider.getChecklistService().deleteChecklistItem(form.getId());
        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public ChecklistItemDTO getForm() {
        return form;
    }

    public void setForm(ChecklistItemDTO form) {
        this.form = form;
    }

    @StrutsParameter
    public Long getChecklistId() {
        return checklistId;
    }

    @StrutsParameter
    public void setChecklistId(Long checklistId) {
        this.checklistId = checklistId;
    }
}
