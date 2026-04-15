package me.dgrachov.studyplanner.service;

import me.dgrachov.studyplanner.exception.ServiceException;
import me.dgrachov.studyplanner.model.TaskChecklistItem;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

import java.util.Optional;

public class TaskChecklistItemService {

    public void toggleCompletion(Long taskChecklistItemId, boolean isCompleted) {
        Optional<TaskChecklistItem> itemOptional = DAOFactory.getFactory().getTaskChecklistItemDAO().findById(taskChecklistItemId);

        if (itemOptional.isEmpty()) {
            throw new ServiceException("Task checklist item not found.");
        }

        TaskChecklistItem item = itemOptional.get();
        item.setCompleted(isCompleted);

        DAOFactory.getFactory().getTaskChecklistItemDAO().merge(item);
    }
}
