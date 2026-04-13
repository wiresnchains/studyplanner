package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.persistence.dao.ChecklistDAO;

public class DummyChecklistDAO extends DummyGenericDAO<Checklist, Long> implements ChecklistDAO {
    public DummyChecklistDAO() {
        super(Checklist::getId);
    }
}
