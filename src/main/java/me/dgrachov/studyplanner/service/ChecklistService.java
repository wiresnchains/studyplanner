package me.dgrachov.studyplanner.service;

import java.util.List;

import me.dgrachov.studyplanner.dto.ChecklistDTO;
import me.dgrachov.studyplanner.mapper.MapperProvider;
import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

public class ChecklistService {
	
	MapperProvider mapper = MapperProvider.getInstance();
	
	
	public List<Checklist> show(Account account) {
		return account.getChecklists();
	}
	
	public void create(Account account, ChecklistDTO checklist) {
		Checklist baseChecklist = mapper.getChecklistMapper().toBase(checklist);
		account.addChecklist(baseChecklist);
		DAOFactory.getFactory().getChecklistDAO().persist(baseChecklist);
	}
	
	public void delete(Account account, ChecklistDTO checklist) {
		account.removeChecklist(mapper.getChecklistMapper().toBase(checklist));
		DAOFactory.getFactory().getAccountDAO().merge(account);
	}
	
	public void edit(Account account, ChecklistDTO newChecklist) {
		Checklist baseChecklist = mapper.getChecklistMapper().toBase(newChecklist);
		account.changeChecklist(baseChecklist);
		DAOFactory.getFactory().getChecklistDAO().merge(baseChecklist);
	}

}
