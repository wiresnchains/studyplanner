package me.dgrachov.studyplanner.action.task;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.dto.TaskDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

import java.util.List;

public class ShowTaskAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private List<TaskDTO> tasks;

    @Override
    public String execute() {
        tasks = serviceProvider.getTaskService().getTasksOfAccount(account);

        return SUCCESS;
    }

    @StrutsParameter(depth = 2)
    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
