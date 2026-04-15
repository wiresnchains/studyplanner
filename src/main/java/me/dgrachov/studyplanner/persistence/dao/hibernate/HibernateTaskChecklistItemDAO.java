package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.model.TaskChecklistItem;
import me.dgrachov.studyplanner.persistence.dao.TaskChecklistItemDAO;

public class HibernateTaskChecklistItemDAO extends HibernateGenericDAO<TaskChecklistItem, Long> implements TaskChecklistItemDAO {
    public HibernateTaskChecklistItemDAO() {
        super(TaskChecklistItem.class);
    }
}
