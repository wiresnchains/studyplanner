<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="edit" namespace="/subject">
    <s:hidden name="subject.id" />
    
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <s:textfield cssClass="form-control" id="name" name="subject.name" />
    </div>

    <select name="subject.color" id="color" class="form-select mb-2">
        <option value="RED" <s:if test="subject.color == 'RED'">selected</s:if>>Red</option>
        <option value="GREEN" <s:if test="subject.color == 'GREEN'">selected</s:if>>Green</option>
        <option value="BLUE" <s:if test="subject.color == 'BLUE'">selected</s:if>>Blue</option>
        <option value="PURPLE" <s:if test="subject.color == 'PURPLE'">selected</s:if>>Purple</option>
        <option value="ORANGE" <s:if test="subject.color == 'ORANGE'">selected</s:if>>Orange</option>
    </select>

    <s:submit cssClass="btn btn-primary mr-2" value="Save" />

    <a href="<s:url value='/subject/' />" class="btn btn-secondary">Cancel</a>
</s:form>
