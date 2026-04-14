<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="create" namespace="/subject">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <s:textfield cssClass="form-control" id="name" name="form.name" />
    </div>

    <s:submit cssClass="btn-create mr-2" value="Create" />

    <a href="<s:url value='/subject/' />" class="btn-danger btn-link-fix">Cancel</a>
</s:form>
