package me.dgrachov.studyplanner.action.mailbox;

import java.util.List;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import me.dgrachov.studyplanner.action.AccountSessionAwareAction;
import me.dgrachov.studyplanner.dto.AccountMessageDTO;
import me.dgrachov.studyplanner.service.ServiceProvider;

public class ShowAllMessagesAction extends AccountSessionAwareAction {
    private static final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    private List<AccountMessageDTO> messages;

    public String execute() {
        messages = serviceProvider.getMailboxService().getAccountMessages(account);

        return SUCCESS;
    }

    @StrutsParameter(depth = 2)
    public List<AccountMessageDTO> getMessages() {
        return messages;
    }
}
