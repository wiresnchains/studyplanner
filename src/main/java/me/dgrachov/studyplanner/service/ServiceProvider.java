package me.dgrachov.studyplanner.service;

public class ServiceProvider {
    private static ServiceProvider instance;

    private final AuthService authService = new AuthService();
    private final MailboxService mailboxService = new MailboxService();
    private final SubjectService subjectService = new SubjectService();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        if (instance == null) {
            instance = new ServiceProvider();
        }

        return instance;
    }

    public AuthService getAuthService() {
        return authService;
    }

    public MailboxService getMailboxService() {
        return mailboxService;
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }
}
