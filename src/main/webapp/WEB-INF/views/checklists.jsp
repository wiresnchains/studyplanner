<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>

<s:form action="create" namespace="/checklist" class="mb-2">
    <s:hidden name="showPage" value="true" />
    <s:submit cssClass="btn-create" value="Create" />
</s:form>

<div class="table-wrapper">
	<table class="table">
		<thead>
		<tr>
			<th>Id</th>
			<th>Naam</th>
			<th>Actie</th>
		</tr>
		</thead>
		<tbody>
		<s:iterator value="checklists" var="checklist">
			    <tr class="checklist-row"
			        data-checklist-id="<s:property value='#checklist.id'/>"
			        data-checklist-name="<s:property value='#checklist.name'/>"
			        data-checklist-account="<s:property value='#checklist.account'/>">
			
			        <td class="checklist-id">
			            <s:property value="#checklist.id"/>
			        </td>
			
			        <td>
			            <s:property value="#checklist.name"/>
			        </td>
			
			        <td class="action-btns">
			            <s:form action="edit" namespace="/checklist">
		                    <s:hidden name="showPage" value="true" />
		                    <s:hidden name="checklist.id" value="%{id}" />
		                    <s:hidden name="checklist.name" value="%{name}" />

                    		<s:submit cssClass="btn-secondary" value="Edit" />
                		</s:form>
			
			            <s:form action="delete" namespace="/checklist">
                    		<s:hidden name="form.checklistId" value="%{id}" />

                    		<s:submit cssClass="btn-danger" value="Delete" />
                		</s:form>
			        </td>
			    </tr>
			</s:iterator>
		</tbody>
	</table>
</div>
