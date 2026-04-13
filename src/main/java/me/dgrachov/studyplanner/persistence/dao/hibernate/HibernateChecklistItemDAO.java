package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.model.ChecklistItem;
import me.dgrachov.studyplanner.persistence.dao.ChecklistItemDAO;

public class HibernateChecklistItemDAO extends HibernateGenericDAO<ChecklistItem, Long> implements ChecklistItemDAO {
    public HibernateChecklistItemDAO() {
        super(ChecklistItem.class);
    }
}
