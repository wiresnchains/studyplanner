package me.dgrachov.studyplanner.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;
import me.dgrachov.studyplanner.persistence.dao.dummy.DummyDAOFactory;
import me.dgrachov.studyplanner.service.AuthService;
import me.dgrachov.studyplanner.util.HashUtil;

public class AuthServiceTest {
    private static final String ACCOUNT_PASS = "test";
    private static Algorithm algorithm;

    private AuthService authService;
    private Account account;

    @BeforeAll
    public static void beforeAll() {
        algorithm = Algorithm.HMAC256("TEST_AUTH_SECRET");
    }

    @AfterAll
    public static void afterAll() {
        algorithm = null;
    }

    @BeforeEach
    public void beforeEach() {
        DAOFactory.setFactory(new DummyDAOFactory());
        authService = new AuthService(algorithm);

        account = new Account();
        account.setId(1L);
        account.setEmail("test@example.com");
        account.setUsername("test");
        account.setPasswordHashed(HashUtil.make(ACCOUNT_PASS));
        DAOFactory.getFactory().getAccountDAO().persist(account);
    }

    @AfterEach
    public void afterEach() {
        DAOFactory.setFactory(null);
        authService = null;
    }

    @Test
    public void testLogin() {
    }

    @Test
    public void testRegister() {
    }

    @Test
    public void testCreateSession() {
        var token = authService.createSession(account);

        var verifier = JWT.require(algorithm).withIssuer("studyplanner").build();
        var jwt = verifier.verify(token);

        var accountId = Long.parseLong(jwt.getSubject());
        assertEquals(account.getId(), accountId);
    }

    @Test
    public void testFindSession() {
        var now = Instant.now();

        var token = JWT.create()
                .withIssuer("studyplanner")
                .withSubject(account.getId().toString())
                .withIssuedAt(now)
                .withExpiresAt(now.plus(7, ChronoUnit.DAYS))
                .sign(algorithm);

        var foundAccount = authService.findAccountFromSession(token);
        assertEquals(account.getId(), foundAccount.getId());
    }
}
