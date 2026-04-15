package me.dgrachov.studyplanner.action.task;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.dto.TaskDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

import java.util.List;

public class CreateTaskAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private TaskDTO task = new TaskDTO();
    private Boolean showPage = false;
    private List<SubjectDTO> subjects;

    @Override
    public String execute() {
        subjects = serviceProvider.getSubjectService().getSubjectsOfAccount(account);

        if (showPage || task == null) {
            return "showPage";
        }

        serviceProvider.getTaskService().create(task, null, null, account);

        return SUCCESS;
    }

    @StrutsParameter
    public void setShowPage(Boolean showPage) {
        this.showPage = showPage;
    }

    @StrutsParameter(depth = 1)
    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }
}