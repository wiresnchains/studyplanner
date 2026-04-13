package me.dgrachov.studyplanner.action.checklist;

import java.util.Map;

import org.apache.struts2.ActionSupport;
import org.apache.struts2.action.SessionAware;

import me.dgrachov.studyplanner.model.checklist.Checklist;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class CreateChecklistAction extends ActionSupport implements SessionAware {
	
	private Checklist checklist;
	
	private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

	public String execute() {
		serviceProvider.getChecklistService().create(null);
		return ERROR;
	}

	@Override
	public void withSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
	}
}
