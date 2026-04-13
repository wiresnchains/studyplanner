package me.dgrachov.studyplanner.mapper;

public class MapperProvider {
    private static MapperProvider instance;

    private final AccountMapper accountMapper = new AccountMapper();
    private final AccountMessageMapper accountMessageMapper = new AccountMessageMapper();
    private final SubjectMapper subjectMapper = new SubjectMapper();

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
}
