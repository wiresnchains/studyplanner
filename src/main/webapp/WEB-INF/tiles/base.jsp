<!doctype html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
        <link rel="stylesheet" href="<s:url value='/css/bootstrap.min.css' />" />
        <title><tiles:insertAttribute name="title" /> - Studyplanner</title>
    </head>
    <body class="bg-body-tertiary">
        <tiles:insertAttribute name="body" />
        
        <script type="text/javascript" src="<s:url value='/js/popper.min.js' />"></script>
        <script type="text/javascript" src="<s:url value='/js/bootstrap.min.js' />"></script>
    </body>
</html>
