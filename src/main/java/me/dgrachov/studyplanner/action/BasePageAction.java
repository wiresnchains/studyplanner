package me.dgrachov.studyplanner.action;

import org.apache.struts2.ActionSupport;

public class BasePageAction extends ActionSupport {
    @Override
    public String execute() {
        return SUCCESS;
    }
}
