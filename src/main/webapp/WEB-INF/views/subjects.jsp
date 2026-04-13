<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="create" namespace="/subject" class="mb-2">
    <s:hidden name="showPage" value="true" />
    <s:submit cssClass="btn-create" value="Create" />
</s:form>

<div class="d-flex flex-wrap gap-2">
    <s:iterator value="subjects">
        <div class="card" style="width: 18rem;">
            <div class="card-header">
                <s:property value="name" />
            </div>

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
    </s:iterator>
</div>
