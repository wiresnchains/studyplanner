<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<s:url value='/css/checklist.css' />"/>

<s:form action="create" namespace="/checklistItem">
    <s:hidden name="checklistId"/>
    
    <div class="mb-3">
	   	<label for="name" class="form-label">Item</label>
	    <s:textfield cssClass="form-control" id="name" name="form.name" />
    </div>

    <s:submit cssClass="btn-create mr-2" value="Save" />

    <a href="<s:url value='/checklist/' />" class="btn-danger btn-link-fix">Cancel</a>

</s:form>

<table class="table">
	<thead>
		<tr id="table-top">
			<th>Item</th>
			<th>Actie</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="checklistItems" var="checklistItem">
			<tbody></tbody>
			<tr class="checklist-row">
				<td>
					<s:property value="name"/>
				</td>
				<td class="action-btns">
					<s:form action="delete" namespace="/checklistItem">
						<s:hidden name="form.checklistItemId" value="%{id}" />
						<s:hidden name="checklistId" value="%{#attr.checklistId}"/>
						<s:submit cssClass="btn-danger" value="Delete" />
					</s:form>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
