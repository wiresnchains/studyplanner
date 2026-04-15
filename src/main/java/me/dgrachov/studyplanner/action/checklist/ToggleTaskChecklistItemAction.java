package me.dgrachov.studyplanner.action.checklist;

import org.apache.struts2.interceptor.parameter.StrutsParameter;
import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.TaskChecklistItemDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class ToggleTaskChecklistItemAction extends AccountSessionAwareAction {

    private TaskChecklistItemDTO form = new TaskChecklistItemDTO();
    private Long taskId;

    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    public String execute() {
        serviceProvider.getTaskChecklistItemService().toggleCompletion(form.getId(), form.isCompleted());
        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public TaskChecklistItemDTO getForm() {
        return form;
    }

    @StrutsParameter(depth = 1)
    public void setForm(TaskChecklistItemDTO form) {
        this.form = form;
    }

    @StrutsParameter
    public Long getTaskId() {
        return taskId;
    }

    @StrutsParameter
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
