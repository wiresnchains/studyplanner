package me.dgrachov.studyplanner.mapper;

public class MapperProvider {
    private static MapperProvider instance;

    private final AccountMapper accountMapper = new AccountMapper();
    private final AccountMessageMapper accountMessageMapper = new AccountMessageMapper();
    private final SubjectMapper subjectMapper = new SubjectMapper();
    private final TaskMapper taskMapper = new TaskMapper();
    private final ChecklistMapper checklistMapper = new ChecklistMapper();
    private final ChecklistItemMapper checklistItemMapper = new ChecklistItemMapper();
    private final TaskChecklistItemMapper taskChecklistItemMapper = new TaskChecklistItemMapper();

    private MapperProvider() {
    }

    public static MapperProvider getInstance() {
        if (instance == null) {
            instance = new MapperProvider();
        }

        return instance;
    }

    public AccountMapper getAccountMapper() {
        return accountMapper;
    }

    public AccountMessageMapper getAccountMessageMapper() {
        return accountMessageMapper;
    }

    public SubjectMapper getSubjectMapper() {
        return subjectMapper;
    }

    public TaskMapper getTaskMapper() {
        return taskMapper;
    }

    public ChecklistMapper getChecklistMapper() {
        return checklistMapper;
    }

    public ChecklistItemMapper getChecklistItemMapper() {
        return checklistItemMapper;
    }

    public TaskChecklistItemMapper getTaskChecklistItemMapper() {
        return taskChecklistItemMapper;
    }
}
