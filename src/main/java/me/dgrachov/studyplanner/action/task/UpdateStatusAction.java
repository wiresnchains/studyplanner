package me.dgrachov.studyplanner.action.task;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.exception.ServiceException;
import me.dgrachov.studyplanner.model.Status;
import me.dgrachov.studyplanner.service.ServiceProvider;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

public class UpdateStatusAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private Long taskId;
    private String status;

    @Override
    public String execute() {
        if (taskId == null || status == null) {
            return ERROR;
        }
        try {
            serviceProvider.getTaskService().updateStatus(taskId, Status.valueOf(status));
        } catch (ServiceException e) {
            addActionError(e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @StrutsParameter
    public void setTaskId(Long taskId) { this.taskId = taskId; }
    public Long getTaskId() { return taskId; }

    @StrutsParameter
    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
}
