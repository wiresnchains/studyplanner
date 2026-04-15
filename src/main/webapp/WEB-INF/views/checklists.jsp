<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/tumbleweed.css' />"/>

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

<link rel="stylesheet" href="<s:url value='/css/TheWatcher.css' />"/>
<img id="eye" src="<s:url value='/img/TheWatcher.gif' />" alt="eye" style="position: fixed; display: none; pointer-events: none; z-index: 9999;" />
<script src="<s:url value='/js/TheWatcher.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<img id="hair" src="<s:url value='/img/hair.png' />" alt="hair">
<script src="<s:url value='/js/hair.js' />"></script>