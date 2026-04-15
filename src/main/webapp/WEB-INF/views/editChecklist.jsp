<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="create" namespace="/checklistItem">
    <s:hidden name="checklist.id" />
    
    <div class="mb-3">
	   	<label for="name" class="form-label">Item</label>
	    <s:textfield cssClass="form-control" id="name" name="form.name" />
    </div>

    <s:submit cssClass="btn-create mr-2" value="Save" />

    <a href="<s:url value='/checklist/' />" class="btn-danger btn-link-fix">Cancel</a>

</s:form>

<s:iterator value="checklist.checklistItems" var="checklistItem">
	<s:property value="#checklistItem.name"/>
</s:iterator>

<link rel="stylesheet" href="<s:url value='/css/TheWatcher.css' />"/>
<img id="eye" src="<s:url value='/img/TheWatcher.gif' />" alt="eye" style="position: fixed; display: none; pointer-events: none; z-index: 9999;" />
<script src="<s:url value='/js/TheWatcher.js' />"></script>
