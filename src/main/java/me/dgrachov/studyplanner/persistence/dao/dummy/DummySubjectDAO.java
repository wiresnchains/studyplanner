package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.model.Subject;
import me.dgrachov.studyplanner.persistence.dao.SubjectDAO;

public class DummySubjectDAO extends DummyGenericDAO<Subject, Long> implements SubjectDAO {
    public DummySubjectDAO() {
        super(Subject::getId);
    }
}
