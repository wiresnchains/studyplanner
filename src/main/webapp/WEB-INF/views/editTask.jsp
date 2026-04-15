<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<s:url value='/css/base.css' />"/>
<s:form action="edit" namespace="/task">
  <s:hidden name="task.id" />

  <div class="mb-3">
    <label class="form-label">Name</label>
    <s:textfield name="task.name" cssClass="form-control" />
  </div>

  <div class="mb-3">
    <label class="form-label">Description</label>
    <s:textarea name="task.description" cssClass="form-control" rows="3" />
  </div>

  <div class="mb-3">
    <label class="form-label">Priority</label>
    <s:select name="task.priority"
              list="#{'HIGH':'High', 'MEDIUM':'Medium', 'LOW':'Low'}"
              cssClass="form-select" />
  </div>

  <div class="mb-3">
    <label class="form-label">Subject</label>
    <s:select name="task.subjectId"
              list="subjects"
              listKey="id"
              listValue="name"
              headerKey=""
              headerValue="-- No subject --"
              cssClass="form-select" />
  </div>

  <div class="mb-3">
    <label class="form-label">Deadline</label>
    <s:textfield type="date" name="task.deadline" cssClass="form-control" />
  </div>

  <s:hidden name="task.status" />

  <s:submit cssClass="btn-create mr-2" value="Save Changes" />
  <a href="<s:url value='/task/' />" class="btn-danger btn-link-fix">Cancel</a>

</s:form>

<s:if test="task.checklistItems != null && !task.checklistItems.isEmpty()">
    <h3 class="mt-4">Checklist</h3>
    <table class="table">
        <thead>
            <tr>
                <th>Item</th>
                <th>Completed</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="task.checklistItems" var="item">
                <tr>
                    <td><s:property value="name" /></td>
                    <td>
                        <s:form action="toggle" namespace="/taskChecklistItem">
                            <s:hidden name="form.id" value="%{id}" />
                            <s:hidden name="taskId" value="%{task.id}" />
                            <s:checkbox name="form.completed" value="%{completed}" onchange="this.form.submit()" />
                        </s:form>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</s:if>

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

<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<img id="hair" src="<s:url value='/img/hair.png' />" alt="hair">
<script src="<s:url value='/js/hair.js' />"></script>
