package me.dgrachov.studyplanner.action.mailbox;

import org.apache.struts2.interceptor.parameter.StrutsParameter;
import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class ReadMessageAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private Long messageId;

    @Override
    public String execute() {
        serviceProvider.getMailboxService().readMessage(messageId);

        return SUCCESS;
    }

    @StrutsParameter
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
}
