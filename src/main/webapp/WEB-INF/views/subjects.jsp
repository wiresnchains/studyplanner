<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<s:form action="create" namespace="/subject" class="mb-2">
    <s:hidden name="showPage" value="true" />
    <s:submit cssClass="btn-create" value="+ Create subject" />
</s:form>

<div class="d-flex flex-wrap gap-2">
    <s:iterator value="subjects">
        <div class="card" style="width: 18rem;">
            <div class="card-header d-flex align-items-center gap-2">
                <span style="display:inline-block;width:12px;height:12px;border-radius:50%;background-color:<s:property value='color.toLowerCase()' />;"></span>
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

<link rel="stylesheet" href="<s:url value='/css/TheWatcher.css' />"/>
<img id="eye" src="<s:url value='/img/TheWatcher.gif' />" alt="eye" style="position: fixed; display: none; pointer-events: none; z-index: 9999;" />
<script src="<s:url value='/js/TheWatcher.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<img id="hair" src="<s:url value='/img/hair.png' />" alt="hair">
<script src="<s:url value='/js/hair.js' />"></script>
