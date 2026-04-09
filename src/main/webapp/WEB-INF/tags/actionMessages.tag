<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="actionMessages">
    <div class="alert alert-primary mb-3" role="alert">
        <s:property />
    </div>
</s:iterator>

<s:iterator value="actionErrors">
    <div class="alert alert-danger mb-3" role="alert">
        <s:property />
    </div>
</s:iterator>
