package me.dgrachov.studyplanner.service;

import me.dgrachov.studyplanner.exception.*;
import me.dgrachov.studyplanner.exception.auth.*;
import me.dgrachov.studyplanner.form.LoginForm;
import me.dgrachov.studyplanner.form.RegisterForm;
import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;
import me.dgrachov.studyplanner.util.HashUtil;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

public class AuthService {
    private final Algorithm algorithm;

    public AuthService() throws RuntimeException {
        try {
            Properties props = new Properties();

            try (InputStream in = getClass().getResourceAsStream("/secrets.properties")) {
                props.load(in);
            }

            algorithm = Algorithm.HMAC256(props.getProperty("auth.secret"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public AuthService(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String login(LoginForm form)
            throws InvalidCredentialsException {
        var accountOptional = DAOFactory.getFactory().getAccountDAO().findByUsername(form.getUsername());

        if (accountOptional.isEmpty()) {
            throw new InvalidCredentialsException("Account with username " + form.getUsername() + " does not exist");
        }

        var account = accountOptional.get();

        if (!HashUtil.verify(form.getPassword(), account.getPasswordHashed())) {
            throw new InvalidCredentialsException("Invalid password");
        }

        return createSession(account);
    }

    public Account register(RegisterForm form)
            throws EmptyFieldsException, CredentialsTakenException, ServiceException {
        if (!form.getAgreeTos()) {
            throw new EmptyFieldsException("You cannot register an account without agreeing to terms and conditions");
        }

        if (!form.getPassword().equals(form.getConfirmPassword())) {
            throw new ServiceException("Passwords do not match");
        }

        var accountOptional = DAOFactory.getFactory().getAccountDAO().findByEmailOrUsername(form.getEmail(),
                form.getUsername());

        if (accountOptional.isPresent()) {
            throw new CredentialsTakenException("An account with these credentials already exists");
        }

        var account = new Account();

        account.setEmail(form.getEmail());
        account.setUsername(form.getUsername());
        account.setPasswordHashed(HashUtil.make(form.getPassword()));

        DAOFactory.getFactory().getAccountDAO().persist(account);

        return account;
    }

    public String createSession(Account account) throws JWTCreationException {
        var now = Instant.now();

        return JWT.create()
                .withIssuer("studyplanner")
                .withSubject(account.getId().toString())
                .withIssuedAt(now)
                .withExpiresAt(now.plus(7, ChronoUnit.DAYS))
                .sign(algorithm);
    }

    public Account findAccountFromSession(String token) throws InvalidAccountSessionException {
        try {
            var verifier = JWT.require(algorithm).withIssuer("studyplanner").build();
            var jwt = verifier.verify(token);

            var accountId = Long.parseLong(jwt.getSubject());
            var accountOptional = DAOFactory.getFactory().getAccountDAO().findById(accountId);

            if (accountOptional.isEmpty()) {
                throw new InvalidAccountSessionException("Account not found");
            }

            return accountOptional.get();
        } catch (JWTVerificationException ex) {
            throw new InvalidAccountSessionException("Account session has expired");
        }
    }
}
