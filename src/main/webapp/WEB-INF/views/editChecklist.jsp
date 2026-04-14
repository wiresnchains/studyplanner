<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="edit" namespace="/checklist">
    <s:hidden name="checklist.id" />
    
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <s:textfield cssClass="form-control" id="name" name="checklist.name" />
    </div>

    <s:submit cssClass="btn-create mr-2" value="Save" />

    <a href="<s:url value='/checklist/' />" class="btn-danger btn-link-fix">Cancel</a>

</s:form>
