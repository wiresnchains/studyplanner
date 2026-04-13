package me.dgrachov.studyplanner.mapper;

public class MapperProvider {
    private static MapperProvider instance;

    private final AccountMapper accountMapper = new AccountMapper();
    private final AccountMessageMapper accountMessageMapper = new AccountMessageMapper();

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
}
