package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.model.ChecklistItem;
import me.dgrachov.studyplanner.persistence.dao.ChecklistItemDAO;

public class DummyChecklistItemDAO extends DummyGenericDAO<ChecklistItem, Long> implements ChecklistItemDAO {
    public DummyChecklistItemDAO() {
        super(ChecklistItem::getId);
    }
}
