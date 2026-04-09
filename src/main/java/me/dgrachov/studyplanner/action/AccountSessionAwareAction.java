package me.dgrachov.studyplanner.action;

import org.apache.struts2.ActionSupport;
import org.apache.struts2.action.SessionAware;
import me.dgrachov.studyplanner.interceptor.AccountSessionInterceptor;
import me.dgrachov.studyplanner.model.Account;

import java.util.Map;

public abstract class AccountSessionAwareAction extends ActionSupport implements SessionAware {
    protected Map<String, Object> session;
    protected Account account;

    @Override
    public void withSession(Map<String, Object> map) {
        this.session = map;
        account = (Account) map.get(AccountSessionInterceptor.CURRENT_ACCOUNT_SESSION_KEY);
    }
}
