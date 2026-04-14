<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="create" namespace="/subject">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <s:textfield cssClass="form-control" id="name" name="form.name" />
    </div>

    <s:submit cssClass="btn-create mr-2" value="Create" />

    <a href="<s:url value='/subject/' />" class="btn-danger btn-link-fix">Cancel</a>
</s:form>

<canvas id="fly-trail"></canvas>
<img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<script src="<s:url value='/js/fly.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/tumbleweed.css' />"/>
<div id="tumbleweed">
    <img src="<s:url value='/img/tumbleweed.png' />" alt="tumbleweed" />
</div>
<script src="<s:url value='/js/tumbleweed.js' />"></script>