<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<s:form action="create" namespace="/subject" class="mb-2">
    <s:hidden name="showPage" value="true" />
    <s:submit cssClass="btn-create" value="+ Create subject" />
</s:form>

<div class="d-flex flex-wrap gap-2">
    <s:iterator value="subjects">
        <div class="card" style="width: 18rem;">
            <div class="card-header">
                <s:property value="name" />
            </div>

            <div class="d-flex gap-2 p-2">
                <s:form action="edit" namespace="/subject">
                    <s:hidden name="showPage" value="true" />
                    <s:hidden name="subject.id" value="%{id}" />
                    <s:hidden name="subject.name" value="%{name}" />
                    <s:hidden name="subject.color" value="%{color}" />

                    <s:submit cssClass="btn-secondary" value="Edit" />
                </s:form>

                <s:form action="delete" namespace="/subject">
                    <s:hidden name="form.subjectId" value="%{id}" />

                    <s:submit cssClass="btn-danger" value="Delete" />
                </s:form>
            </div>
        </div>
    </s:iterator>
    <canvas id="fly-trail"></canvas>
    <img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
</div>
<script src="<s:url value='/js/fly.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/tumbleweed.css' />"/>
<div id="tumbleweed">
    <img src="<s:url value='/img/tumbleweed.png' />" alt="tumbleweed" />
</div>
<script src="<s:url value='/js/tumbleweed.js' />"></script>
