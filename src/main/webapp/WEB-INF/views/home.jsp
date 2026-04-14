<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/tumbleweed.css' />"/>

<h3>Hello, world!</h3>

<canvas id="fly-trail"></canvas>
<img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
<img id="hair" src="<s:url value='/img/hair.png' />" alt="hair">

    <div id="tumbleweed">
        <img src="<s:url value='/img/tumbleweed.png' />" alt="tumbleweed" />
    </div>
<script src="<s:url value='/js/fly.js' />"></script>
<script src="<s:url value='/js/hair.js' />"></script>
<script src="<s:url value='/js/tumbleweed.js' />"></script>
