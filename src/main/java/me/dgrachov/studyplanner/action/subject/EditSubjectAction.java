package me.dgrachov.studyplanner.action.subject;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class EditSubjectAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private SubjectDTO subject;
    private Boolean showPage;

    @Override
    public String execute() {
        if (showPage) {
            return "showPage";
        }

        serviceProvider.getSubjectService().editSubject(subject);

        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public SubjectDTO getSubject() {
        return subject;
    }

    @StrutsParameter(depth = 1)
    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    @StrutsParameter
    public void setShowPage(Boolean showPage) {
        this.showPage = showPage;
    }
}
