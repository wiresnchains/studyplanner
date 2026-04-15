package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.persistence.dao.*;

public class DummyDAOFactory extends DAOFactory {
    private final DummyAccountDAO accountDAO = new DummyAccountDAO();
    private final DummyAccountMessageDAO accountMessageDAO = new DummyAccountMessageDAO();
    private final DummySubjectDAO subjectDAO = new DummySubjectDAO();
    private final DummyTaskDAO taskDAO = new DummyTaskDAO();
    private final DummyChecklistDAO checklistDAO = new DummyChecklistDAO();
    private final DummyChecklistItemDAO checklistItemDAO = new DummyChecklistItemDAO();
    private final DummyTaskChecklistDAO taskChecklistDAO = new DummyTaskChecklistDAO();

    @Override
    public DummyAccountDAO getAccountDAO() {
        return accountDAO;
    }

    @Override
    public DummyAccountMessageDAO getAccountMessageDAO() {
        return accountMessageDAO;
    }

    @Override
    public DummySubjectDAO getSubjectDAO() {
        return subjectDAO;
    }

    @Override
    public TaskDAO getTaskDAO() {
        return taskDAO;
    }

    @Override
    public ChecklistDAO getChecklistDAO() {
        return checklistDAO;
    }

    @Override
    public ChecklistItemDAO getChecklistItemDAO() {
        return checklistItemDAO;
    }

    @Override
    public TaskChecklistItemDAO getTaskChecklistItemDAO() {return taskChecklistDAO;}
}
