package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.model.Task;
import me.dgrachov.studyplanner.persistence.dao.TaskDAO;

public class HibernateTaskDAO extends HibernateGenericDAO<Task, Long> implements TaskDAO {
    public HibernateTaskDAO() {
        super(Task.class);
    }
}
