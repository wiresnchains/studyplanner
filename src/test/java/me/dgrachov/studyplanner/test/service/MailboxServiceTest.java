package me.dgrachov.studyplanner.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.model.AccountMessage;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;
import me.dgrachov.studyplanner.persistence.dao.dummy.DummyDAOFactory;
import me.dgrachov.studyplanner.service.MailboxService;

public class MailboxServiceTest {
    private MailboxService mailboxService;
    private Account account1;
    private Account account2;

    @BeforeEach
    public void beforeEach() {
        DAOFactory.setFactory(new DummyDAOFactory());

        account1 = new Account();
        account1.setId(1L);
        DAOFactory.getFactory().getAccountDAO().persist(account1);

        account2 = new Account();
        account2.setId(2L);
        DAOFactory.getFactory().getAccountDAO().persist(account2);

        mailboxService = new MailboxService();
    }

    @AfterEach
    public void afterEach() {
        account1 = null;
        account2 = null;
        mailboxService = null;
        DAOFactory.setFactory(null);
    }

    @Test
    public void testSendMessage() {
        var sender = "Test";
        var content = "Test content";

        var sentMessage = mailboxService.sendMessage(sender, content, account1);

        assertEquals(sender, sentMessage.getSender());
        assertEquals(content, sentMessage.getContent());
        assertEquals(account1.getId(), sentMessage.getAccount().getId());

        var accountMessages = DAOFactory.getFactory().getAccountMessageDAO().findAll();

        assertTrue(accountMessages.size() > 0, "Account message was not persisted");
        assertTrue(accountMessages.contains(sentMessage), "Account message was not persisted");
    }

    @Test
    public void testGetUnreadAccountMessages() {

    }

    @Test
    public void testReadMessage() {
        var message1 = new AccountMessage();
        message1.setId(1L);
        message1.setAccount(account1);
        DAOFactory.getFactory().getAccountMessageDAO().persist(message1);

        assertEquals(false, message1.isRead());

        mailboxService.readMessage(message1.getId());

        assertEquals(true, message1.isRead());
    }
}
