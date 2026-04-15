package me.dgrachov.studyplanner.persistence.dao;

public abstract class DAOFactory {
    private static DAOFactory factory;

    public static DAOFactory getFactory() {
        return factory;
    }

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public abstract AccountDAO getAccountDAO();

    public abstract AccountMessageDAO getAccountMessageDAO();

    public abstract SubjectDAO getSubjectDAO();

    public abstract TaskDAO getTaskDAO();

    public abstract ChecklistDAO getChecklistDAO();

    public abstract ChecklistItemDAO getChecklistItemDAO();

    public abstract TaskChecklistItemDAO getTaskChecklistItemDAO();
}
