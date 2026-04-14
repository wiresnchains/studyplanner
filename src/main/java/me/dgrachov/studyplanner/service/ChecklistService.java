package me.dgrachov.studyplanner.service;

import java.util.List;

import me.dgrachov.studyplanner.dto.ChecklistDTO;
import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.exception.ServiceException;
import me.dgrachov.studyplanner.mapper.MapperProvider;
import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

public class ChecklistService {
	
	MapperProvider mapperProvider = MapperProvider.getInstance();
	
	
	public List<Checklist> show(Account account) {
		return account.getChecklists();
	}
	
	public void createChecklist(Account account, String name) {
		Checklist checklist = new Checklist();
		
		checklist.setName(name);
		checklist.setAccount(account);
		
		DAOFactory.getFactory().getChecklistDAO().persist(checklist);
		
		account.getChecklists().add(checklist);
	}
	
	public void deleteChecklist(Long checklistId) {
        var checklistOptional = DAOFactory.getFactory().getChecklistDAO().findById(checklistId);

        if (checklistOptional.isEmpty()) {
            throw new ServiceException("Checklist does not exist");
        }

        var checklist = checklistOptional.get();

        DAOFactory.getFactory().getChecklistDAO().remove(checklist);
    }
	
	public void editChecklist(ChecklistDTO dto) {
        var newChecklist = mapperProvider.getChecklistMapper().toBase(dto);
        var checklistOptional = DAOFactory.getFactory().getChecklistDAO().findById(dto.getId());

        if (checklistOptional.isEmpty()) {
            throw new ServiceException("Checklist does not exist");
        }

        var subject = checklistOptional.get();

        subject.setName(newChecklist.getName());

        DAOFactory.getFactory().getChecklistDAO().merge(subject);
    }

}
