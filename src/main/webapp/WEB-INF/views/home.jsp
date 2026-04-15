<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/tumbleweed.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/TheWatcher.css' />"/>


<div class="window">
    <div class="window-body">
        <h2 class="mb-3">Major L-Ratio Detected</h2>

        <p>
            System alert: Your productivity is looking cooked. We ran a vibe check on your account and you're officially crashing out. You've got negative aura and the Fanum Tax is about to hit your entire database.
        </p>

        <div class="alert alert-info">
            <strong>CRITICAL:</strong> It has come to our attention that StudyPlanner is being used for personal purposes
            (<s:a action="DoNtBElIeveThEm">see the incident of 26</s:a>). This is not acceptable.
        </div>

        <p>
            Stop being a professional yapper and start being a certified grinder. Your subjects are looking mid and your kanban-board is ghosting you. Don't be a beta.
        </p>

        <hr />

        <p class="mt-4 text-muted" style="font-size: 0.75rem;">
            <em>Sent from StudyPlanner <br>
                -<a>https://drive.google.com/drive/folders/1PpW1H5Tlt32usPgpWxfDJEYO-1ULMQa3</a> </em>
        </p>
    </div>
</div>

<img id="eye" src="<s:url value='/img/TheWatcher.gif' />" alt="eye" style="position: fixed; display: none; pointer-events: none; z-index: 9999;" />
<script src="<s:url value='/js/TheWatcher.js' />"></script>

<canvas id="fly-trail"></canvas>
<img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
<img id="hair" src="<s:url value='/img/hair.png' />" alt="hair">

<div id="tumbleweed">
    <img src="<s:url value='/img/tumbleweed.png' />" alt="tumbleweed" />
</div>

<script src="<s:url value='/js/fly.js' />"></script>
<script src="<s:url value='/js/hair.js' />"></script>
<script src="<s:url value='/js/tumbleweed.js' />"></script>