package me.dgrachov.studyplanner.service;

import java.util.List;

import me.dgrachov.studyplanner.dto.AccountMessageDTO;
import me.dgrachov.studyplanner.exception.mailbox.MessageNotFoundException;
import me.dgrachov.studyplanner.mapper.MapperProvider;
import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.model.AccountMessage;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

public class MailboxService {
    private static final MapperProvider mapperProvider = MapperProvider.getInstance();

    public AccountMessage sendMessage(String sender, String content, Account target) {
        var message = new AccountMessage();

        message.setSender(sender);
        message.setContent(content);
        message.setAccount(target);

        DAOFactory.getFactory().getAccountMessageDAO().persist(message);

        return message;
    }

    public List<AccountMessageDTO> getAccountMessages(Account account) {
        return mapperProvider.getAccountMessageMapper().toDTOList(account.getMessages());
    }

    public Long getUnreadAccountMessageCount(Account account) {
        var accountMessages = account.getMessages();
        var unreadMessageCount = 0L;

        for (var message : accountMessages) {
            if (!message.isRead()) {
                unreadMessageCount++;
            }
        }

        return unreadMessageCount;
    }

    public void readMessage(Long messageId) throws MessageNotFoundException {
        var accountMessageOptional = DAOFactory.getFactory().getAccountMessageDAO().findById(messageId);

        if (accountMessageOptional.isEmpty()) {
            throw new MessageNotFoundException("Message with id: " + messageId + " does not exist");
        }

        var accountMessage = accountMessageOptional.get();

        accountMessage.setRead(!accountMessage.isRead());

        DAOFactory.getFactory().getAccountMessageDAO().merge(accountMessage);
    }
}
