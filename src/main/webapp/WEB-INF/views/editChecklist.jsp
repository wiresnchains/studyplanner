<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<s:url value='/css/checklist.css' />"/>

<s:form action="create" namespace="/checklistItem">
    <s:hidden name="checklistId" value="%{checklistId}" />
    <div class="mb-3">
        <label for="name" class="form-label">Item</label>
        <s:textfield cssClass="form-control" id="name" name="form.name" />
    </div>
    <s:submit cssClass="btn-create mr-2" value="Save" />
    <a href="<s:url value='/checklist/' />" class="btn-danger btn-link-fix">Cancel</a>
</s:form>

<s:form action="updatePosition" namespace="/checklistItem" id="reorder-form">
    <s:hidden name="checklistId" value="%{checklistId}" />
</s:form>

<table class="table">
    <thead>
        <tr id="table-top">
            <th>Item</th>
            <th>Move</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody id="checklist-items">
        <s:iterator value="checklistItems" var="item">
            <tr class="checklist-row" data-id="<s:property value='id'/>">
                <td><s:property value="name"/></td>
                <td>
                    <button class="btn btn-sm btn-secondary move-up">Up</button>
                    <button class="btn btn-sm btn-secondary move-down">Down</button>
                </td>
                <td class="action-btns">
                    <s:form action="delete" namespace="/checklistItem">
                        <s:hidden name="form.id" value="%{id}" />
                        <s:hidden name="checklistId" value="%{checklistId}"/>
                        <s:submit cssClass="btn-danger" value="Delete" />
                    </s:form>
                </td>
            </tr>
        </s:iterator>
    </tbody>
</table>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const reorderForm = document.getElementById('reorder-form');
        const checklistItems = document.getElementById('checklist-items');

        checklistItems.addEventListener('click', function (e) {
            if (e.target.classList.contains('move-up')) {
                const row = e.target.closest('tr');
                if (row.previousElementSibling) {
                    row.parentNode.insertBefore(row, row.previousElementSibling);
                    updatePositions();
                }
            } else if (e.target.classList.contains('move-down')) {
                const row = e.target.closest('tr');
                if (row.nextElementSibling) {
                    row.parentNode.insertBefore(row.nextElementSibling, row);
                    updatePositions();
                }
            }
        });

        function updatePositions() {
            const itemIds = Array.from(checklistItems.querySelectorAll('tr')).map(row => row.dataset.id);

            // Clear previous hidden inputs
            reorderForm.querySelectorAll('input[name="itemIds"]').forEach(input => input.remove());

            // Add new hidden inputs
            itemIds.forEach((id, index) => {
                const input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'itemIds';
                input.value = id;
                reorderForm.appendChild(input);
            });
            reorderForm.submit();
        }
    });
</script>

<link rel="stylesheet" href="<s:url value='/css/TheWatcher.css' />"/>
<img id="eye" src="<s:url value='/img/TheWatcher.gif' />" alt="eye" style="position: fixed; display: none; pointer-events: none; z-index: 9999;" />
<script src="<s:url value='/js/TheWatcher.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<img id="hair" src="<s:url value='/img/hair.png' />" alt="hair">
<script src="<s:url value='/js/hair.js' />"></script>
