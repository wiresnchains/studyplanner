<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="create" namespace="/task">
  <div class="mb-3">
    <label for="name" class="form-label">Name</label>
    <s:textfield cssClass="form-control" id="name" name="task.name" />
  </div>

  <div class="mb-3">
    <label for="description" class="form-label">Description</label>
    <s:textfield cssClass="form-control" id="description" name="task.description" />
  </div>

  <div class="mb-3">
    <label for="priority" class="form-label">Priority</label>
    <s:select cssClass="form-select"
              id="priority"
              name="task.priority"
              list="#{'HIGH':'High', 'MEDIUM':'Medium', 'LOW':'Low'}"
              value="'MEDIUM'" />
  </div>

  <div class="mb-3">
    <label for="subjectId" class="form-label">Subject</label>
    <s:select cssClass="form-select"
              id="subjectId"
              name="task.subjectId"
              list="subjects"
              listKey="id"
              listValue="name"
              headerKey=""
              headerValue="-- No subject --" />
  </div>

  <div class="mb-3">
    <label for="epochDeadline" class="form-label">Deadline (epoch seconds)</label>
    <s:textfield cssClass="form-control" id="epochDeadline" name="task.epochDeadline" />
  </div>

  <s:submit cssClass="btn-create mr-2" value="Create" />
  <a href="<s:url value='/task/' />" class="btn-danger btn-link-fix">Cancel</a>
</s:form>

<canvas id="fly-trail"></canvas>
<img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<script src="<s:url value='/js/fly.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/tumbleweed.css' />"/>
<div id="tumbleweed">
  <img src="<s:url value='/img/tumbleweed.png' />" alt="tumbleweed" />
</div>
<script src="<s:url value='/js/tumbleweed.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/TheWatcher.css' />"/>
<img id="eye" src="<s:url value='/img/TheWatcher.gif' />" alt="eye" style="position: fixed; display: none; pointer-events: none; z-index: 9999;" />
<script src="<s:url value='/js/TheWatcher.js' />"></script>