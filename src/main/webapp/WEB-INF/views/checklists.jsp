<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

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
				        data-cabinet-id="<s:property value='#checklist.id'/>"
				        data-cabinet-name="<s:property value='#checklist.name'/>"
				        data-cabinet-description="<s:property value='#checklist.account'/>">
				
				        <td class="checklist-id">
				            <s:property value="#checklist.id"/>
				        </td>
				
				        <td>
				            <s:property value="#checklist.name"/>
				        </td>
				
				        <td class="action-btns">
				            <button type="button"
				                    class="action-btn btn-edit"
				                    data-cabinet-id="<s:property value='#checklist.id'/>"
				                    data-cabinet-name="<s:property value='#checklist.name'/>">
				                    edit
				            </button>
				
				            <button type="button"
				                    class="action-btn btn-delete"
				                    data-cabinet-id="<s:property value='#cabinet.id'/>"
				                    data-cabinet-name="<s:property value='#cabinet.name'/>">
				                    delete
				            </button>
				        </td>
				    </tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

<div class="w-100 m-auto" style="max-width: 400px;">
	<s:form action="create" namespace="/checklist" id="checklistForm">
    	<div class="form-group">
        	<label class="form-label" for="checklistName">Naam</label>
        	<s:textfield type="text" name="checklist.name" id="checklistName" cssClass="form-input" placeholder="Checklist naam" required="true" />
    	</div>
   		<button type="submit" class="btn-submit">Toevoegen</button>
   	</s:form>
</div>
