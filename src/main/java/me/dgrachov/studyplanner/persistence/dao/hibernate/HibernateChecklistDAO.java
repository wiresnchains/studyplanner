package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.persistence.dao.ChecklistDAO;

public class HibernateChecklistDAO extends HibernateGenericDAO<Checklist, Long> implements ChecklistDAO {
    public HibernateChecklistDAO() {
        super(Checklist.class);
    }
}
