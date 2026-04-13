package me.dgrachov.studyplanner.persistence.dao.dummy;

import me.dgrachov.studyplanner.model.Task;
import me.dgrachov.studyplanner.persistence.dao.TaskDAO;

public class DummyTaskDAO extends DummyGenericDAO<Task, Long> implements TaskDAO {
    public DummyTaskDAO() {
        super(Task::getId);
    }
}
