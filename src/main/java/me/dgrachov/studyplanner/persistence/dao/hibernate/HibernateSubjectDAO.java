package me.dgrachov.studyplanner.persistence.dao.hibernate;

import me.dgrachov.studyplanner.model.Subject;
import me.dgrachov.studyplanner.persistence.dao.SubjectDAO;

public class HibernateSubjectDAO extends HibernateGenericDAO<Subject, Long> implements SubjectDAO {
    public HibernateSubjectDAO() {
        super(Subject.class);
    }
}
