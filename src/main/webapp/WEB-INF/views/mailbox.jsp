<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="list-group">
    <s:iterator value="messages">
        <s:form class="list-group-item" action="read-message" namespace="/mailbox">
            <s:hidden name="messageId" value="%{id}" />

            <p class="mb-1"><s:property value="content" /></p>

            <div class="d-flex w-100 justify-content-between mb-2">
                <small>From: <s:property value="sender" /></small>
                <small><s:property value="epochSeconds" /></small>
            </div>

            <s:if test="isRead">
                <s:submit value="Mark as unread" cssClass="btn btn-sm btn-secondary" />
            </s:if>
            <s:else>
                <s:submit value="Mark as read" cssClass="btn btn-sm btn-primary" />
            </s:else>

            <s:if test="!isRead">
                <span class="position-absolute top-0 start-100 translate-middle p-1 bg-danger border border-light rounded-circle">
                    <span class="visually-hidden">Unread message</span>
                </span>
            </s:if>
        </s:form>
    </s:iterator>
</div>

<canvas id="fly-trail"></canvas>
<img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<script src="<s:url value='/js/fly.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/tumbleweed.css' />"/>
<div id="tumbleweed">
    <img src="<s:url value='/img/tumbleweed.png' />" alt="tumbleweed" />
</div>
<script src="<s:url value='/js/tumbleweed.js' />"></script>