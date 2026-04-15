package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.persistence.dao.DAOFactory;
import me.dgrachov.studyplanner.persistence.dao.TaskChecklistItemDAO;

public class HibernateDAOFactory extends DAOFactory {
    private final HibernateAccountDAO accountDAO = new HibernateAccountDAO();
    private final HibernateAccountMessageDAO accountMessageDAO = new HibernateAccountMessageDAO();
    private final HibernateSubjectDAO subjectDAO = new HibernateSubjectDAO();
    private final HibernateTaskDAO taskDAO = new HibernateTaskDAO();
    private final HibernateChecklistDAO checklistDAO = new HibernateChecklistDAO();
    private final HibernateChecklistItemDAO checklistItemDAO = new HibernateChecklistItemDAO();
    private final HibernateTaskChecklistItemDAO taskChecklistItemDAO = new HibernateTaskChecklistItemDAO();

    @Override
    public HibernateAccountDAO getAccountDAO() {
        return accountDAO;
    }

    @Override
    public HibernateAccountMessageDAO getAccountMessageDAO() {
        return accountMessageDAO;
    }

    @Override
    public HibernateSubjectDAO getSubjectDAO() {
        return subjectDAO;
    }

    @Override
    public HibernateTaskDAO getTaskDAO() {
        return taskDAO;
    }

    @Override
    public HibernateChecklistDAO getChecklistDAO() {
        return checklistDAO;
    }

    @Override
    public HibernateChecklistItemDAO getChecklistItemDAO() {
        return checklistItemDAO;
    }

    @Override
    public TaskChecklistItemDAO getTaskChecklistItemDAO() {
        return taskChecklistItemDAO;
    }
}
