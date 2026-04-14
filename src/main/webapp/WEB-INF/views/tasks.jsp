<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/task.css' />"/>

<meta name="ctx" content="<s:url value='/' />" />

<s:form action="create" namespace="/task" class="mb-3">
    <s:hidden name="showPage" value="true" />
    <s:submit cssClass="btn-create" value="+ Create task" />
</s:form>

<div class="kanban-board d-flex gap-3">

    <div class="kanban-column flex-fill" data-status="TODO">
        <div class="kanban-header">To do</div>
        <div class="kanban-cards" id="col-TODO">
            <s:iterator value="tasks">
                <s:if test="status == 'TODO' || status == null">
                    <div class="kanban-card" draggable="true" data-id="<s:property value='id' />" data-status="TODO">
                        <div class="kanban-card-title"><s:property value="name" /></div>
                        <div class="kanban-card-subject text-muted small">
                            <i class="bi bi-book"></i>
                            <s:if test="subjectId != null">
                                <s:property value="subjectName" default="Subject ID: %{subjectId}" />
                            </s:if>
                            <s:else>
                                No subject
                            </s:else>
                        </div>
                        <div class="kanban-card-meta"><s:property value="priority" /></div>
                        <div class="kanban-card-actions">
                            <s:form action="edit" namespace="/task">
                                <s:hidden name="task.id" value="%{id}" />
                                <s:hidden name="showPage" value="true" />
                                <s:submit cssClass="btn-secondary btn-sm" value="Edit" />
                            </s:form>
                            <s:form action="delete" namespace="/task" cssClass="d-inline">
                                <s:hidden name="form.taskId" value="%{id}" />
                                <s:submit cssClass="btn-danger btn-sm" value="Delete" />
                            </s:form>
                        </div>
                    </div>
                </s:if>
            </s:iterator>
        </div>
    </div>

    <div class="kanban-column flex-fill" data-status="IN_PROGRESS">
        <div class="kanban-header">In progress</div>
        <div class="kanban-cards" id="col-IN_PROGRESS">
            <s:iterator value="tasks">
                <s:if test="status == 'IN_PROGRESS'">
                    <div class="kanban-card" draggable="true" data-id="<s:property value='id' />" data-status="IN_PROGRESS">
                        <div class="kanban-card-title"><s:property value="name" /></div>
                        <div class="kanban-card-meta"><s:property value="priority" /></div>
                        <div class="kanban-card-actions">
                            <s:form action="edit" namespace="/task" method="POST">
                                <s:hidden name="showPage" value="true" />
                                <s:hidden name="task.id" value="%{id}" />
                                <s:submit cssClass="btn-secondary btn-sm" value="Edit" />
                            </s:form>
                            <s:form action="delete" namespace="/task" cssClass="d-inline">
                                <s:hidden name="form.taskId" value="%{id}" />
                                <s:submit cssClass="btn-danger btn-sm" value="Delete" />
                            </s:form>
                        </div>
                    </div>
                </s:if>
            </s:iterator>
        </div>
    </div>

    <div class="kanban-column flex-fill" data-status="DONE">
        <div class="kanban-header">Done</div>
        <div class="kanban-cards" id="col-DONE">
            <s:iterator value="tasks">
                <s:if test="status == 'DONE'">
                    <div class="kanban-card" draggable="true" data-id="<s:property value='id' />" data-status="DONE">
                        <div class="kanban-card-title"><s:property value="name" /></div>
                        <div class="kanban-card-meta"><s:property value="priority" /></div>
                        <div class="kanban-card-actions">
                            <s:form action="edit" namespace="/task">
                                <s:hidden name="task.id" value="%{id}" />
                                <s:hidden name="showPage" value="true" />
                                <s:submit cssClass="btn-secondary btn-sm" value="Edit" />
                            </s:form>
                            <s:form action="delete" namespace="/task" cssClass="d-inline">
                                <s:hidden name="form.taskId" value="%{id}" />
                                <s:submit cssClass="btn-danger btn-sm" value="Delete" />
                            </s:form>
                        </div>
                    </div>
                </s:if>
            </s:iterator>
        </div>
    </div>
</div>

<canvas id="fly-trail"></canvas>
<img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
<script src="<s:url value='/js/fly.js' />"></script>

<script>
    const cols = document.querySelectorAll('.kanban-cards');
    let dragged = null;

    document.querySelectorAll('.kanban-card').forEach(card => {
        card.addEventListener('dragstart', () => { dragged = card; card.style.opacity = '0.4'; });
        card.addEventListener('dragend', () => { card.style.opacity = '1'; dragged = null; });
    });

    cols.forEach(col => {
        col.addEventListener('dragover', e => { e.preventDefault(); col.classList.add('drag-over'); });
        col.addEventListener('dragleave', () => col.classList.remove('drag-over'));
        col.addEventListener('drop', e => {
            e.preventDefault();
            col.classList.remove('drag-over');
            if (!dragged) return;

            const taskId = dragged.dataset.id;
            const newStatus = col.id.replace('col-', '');

            col.appendChild(dragged);
            dragged.dataset.status = newStatus;

            const ctx = document.querySelector('meta[name="ctx"]')?.content || '';

            fetch(ctx + '/task/updateStatus.action', {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: 'taskId=' + encodeURIComponent(taskId) +
                    '&status=' + encodeURIComponent(newStatus)
            })
                .then(res => console.log("STATUS:", res.status))
                .catch(err => console.error(err));
        });
    });
</script>