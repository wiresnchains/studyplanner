package me.dgrachov.studyplanner.action.task;

import org.apache.struts2.interceptor.parameter.StrutsParameter;
import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.dto.TaskDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;
import java.util.List;

public class EditTaskAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private TaskDTO task = new TaskDTO();
    private List<SubjectDTO> subjects;
    private Boolean showPage = false;

    @Override
    public String execute() {
        subjects = serviceProvider.getSubjectService().getSubjectsOfAccount(account);

        if (Boolean.TRUE.equals(showPage)) {
            if (task != null && task.getId() != null) {
                task = serviceProvider.getTaskService().getTaskById(task.getId());
            }
            return "showPage";
        }

        serviceProvider.getTaskService().edit(task, null, null);
        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public TaskDTO getTask() {
        return task;
    }

    @StrutsParameter(depth = 1)
    public void setTask(TaskDTO task) {
        this.task = task;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    @StrutsParameter
    public void setShowPage(Boolean showPage) {
        this.showPage = showPage;
    }
}