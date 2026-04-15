package me.dgrachov.studyplanner.action.task;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.ChecklistDTO;
import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.dto.TaskDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

import java.util.List;

public class CreateTaskAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private TaskDTO task = new TaskDTO();
    private Long checklistTemplateId;
    private Boolean showPage = false;
    private List<SubjectDTO> subjects;
    private List<ChecklistDTO> checklistTemplates;

    @Override
    public String execute() {
        subjects = serviceProvider.getSubjectService().getSubjectsOfAccount(account);
        checklistTemplates = serviceProvider.getChecklistService().getChecklistsOfAccount(account);

        if (showPage || task == null) {
            return "showPage";
        }

        serviceProvider.getTaskService().create(task, checklistTemplateId, account);

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

    @StrutsParameter
    public void setChecklistTemplateId(Long checklistTemplateId) {
        this.checklistTemplateId = checklistTemplateId;
    }

    public Long getChecklistTemplateId() {
        return checklistTemplateId;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public List<ChecklistDTO> getChecklistTemplates() {
        return checklistTemplates;
    }
}
