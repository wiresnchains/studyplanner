package me.dgrachov.studyplanner.service;

import java.util.List;
import me.dgrachov.studyplanner.dto.ChecklistDTO;
import me.dgrachov.studyplanner.exception.ServiceException;
import me.dgrachov.studyplanner.mapper.MapperProvider;
import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.model.ChecklistItem;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

public class ChecklistService {
	
	MapperProvider mapperProvider = MapperProvider.getInstance();
	
	
	public List<Checklist> show(Account account) {
		return account.getChecklists();
	}
	
	public List<ChecklistItem> showItems(Checklist checklist) {
		return checklist.getItems();
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

        var checklist = checklistOptional.get();

        checklist.setName(newChecklist.getName());

        DAOFactory.getFactory().getChecklistDAO().merge(checklist);
	}
	
	public void createChecklistItem(Checklist checklist, String name) {
		ChecklistItem checklistItem = new ChecklistItem();
		
		checklistItem.setName(name);
		checklistItem.setChecklist(checklist);
		
		DAOFactory.getFactory().getChecklistItemDAO().persist(checklistItem);
		
		checklist.getItems().add(checklistItem);
	}

}
