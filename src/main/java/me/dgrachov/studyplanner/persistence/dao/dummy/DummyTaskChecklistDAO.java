package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.model.TaskChecklistItem;
import me.dgrachov.studyplanner.persistence.dao.TaskChecklistItemDAO;

public class DummyTaskChecklistDAO extends DummyGenericDAO<TaskChecklistItem, Long> implements TaskChecklistItemDAO {
    public DummyTaskChecklistDAO() {
        super(TaskChecklistItem::getId);
    }
}
