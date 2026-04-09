package me.dgrachov.studyplanner.interceptor;

import org.apache.struts2.ActionInvocation;
import org.apache.struts2.interceptor.AbstractInterceptor;

import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class MailboxInterceptor extends AbstractInterceptor {
    public static final String MAILBOX_UNREAD_MESSAGE_COUNT_KEY = "unreadMailboxMessageCount";

    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        var session = invocation.getInvocationContext().getSession();
        var currentAccount = (Account) session.get(AccountSessionInterceptor.CURRENT_ACCOUNT_SESSION_KEY);

        if (currentAccount != null) {
            session.put(MAILBOX_UNREAD_MESSAGE_COUNT_KEY,
                    serviceProvider.getMailboxService().getUnreadAccountMessageCount(currentAccount));
        }

        try {
            return invocation.invoke();
        } catch (Exception e) {
            throw e;
        } finally {
            session.remove(MAILBOX_UNREAD_MESSAGE_COUNT_KEY);
        }
    }
}
