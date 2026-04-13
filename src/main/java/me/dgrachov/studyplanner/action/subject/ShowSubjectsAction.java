package me.dgrachov.studyplanner.action.subject;

import java.util.List;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class ShowSubjectsAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private List<SubjectDTO> subjects;

    @Override
    public String execute() {
        subjects = serviceProvider.getSubjectService().getSubjectsOfAccount(account);

        return SUCCESS;
    }

    @StrutsParameter(depth = 2)
    public List<SubjectDTO> getSubjects() {
        return subjects;
    }
}
