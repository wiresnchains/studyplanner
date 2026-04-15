<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="create" namespace="/subject">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <s:textfield cssClass="form-control" id="name" name="form.name" />
    </div>

    <div class="mb-3">
        <label for="color" class="form-label">Color</label>
        <select name="form.color" id="color" class="form-select">
            <option value="RED">Red</option>
            <option value="GREEN">Green</option>
            <option value="BLUE" selected>Blue</option>
            <option value="PURPLE">Purple</option>
            <option value="ORANGE">Orange</option>
        </select>
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

<link rel="stylesheet" href="<s:url value='/css/TheWatcher.css' />"/>
<img id="eye" src="<s:url value='/img/TheWatcher.gif' />" alt="eye" style="position: fixed; display: none; pointer-events: none; z-index: 9999;" />
<script src="<s:url value='/js/TheWatcher.js' />"></script>

<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<img id="hair" src="<s:url value='/img/hair.png' />" alt="hair">
<script src="<s:url value='/js/hair.js' />"></script>
