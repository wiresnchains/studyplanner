package me.dgrachov.studyplanner.service;

import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.model.checklist.Checklist;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

public class ChecklistService {
	
	public void create(Account account, String name) {
		var checklist = new Checklist();

        checklist.setName(name);
        DAOFactory.getFactory().getChecklistDAO().persist(checklist);
        
        account.addChecklist(checklist);
	}
	
	public void delete() {
		//TODO
	}
	
	public void edit() {
		//TODO
	}

}
