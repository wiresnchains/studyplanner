<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/hair.css' />"/>
<link rel="stylesheet" href="<s:url value='/css/tumbleweed.css' />"/>

<div class="window">
    <div class="window-body">
        <h2 class="mb-3">Major L-Ratio Detected</h2>

        <p>
            System alert: Your productivity is looking cooked. We ran a vibe check on your account and you're officially crashing out. You've got negative aura and the Fanum Tax is about to hit your entire database.
        </p>

        <div class="alert alert-info">
            <strong>CRITICAL:</strong> Absolute zero rizz detected in your task history. If you don't start mewing and locking in right now, you're getting sent straight to the Ohio trenches. No cap, this is your last warning.
        </div>

        <p>
            Stop being a professional yapper and start being a certified grinder. Your subjects are looking mid and your kanban-board is ghosting you. Don't be a beta.
        </p>

        <hr />

        <p class="mt-4 text-muted" style="font-size: 0.75rem;">
            <em>Sent from the Skibidi Basement <br>
                - The Head Rizzler</em>
        </p>
    </div>
</div>

<canvas id="fly-trail"></canvas>
<img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
<img id="hair" src="<s:url value='/img/hair.png' />" alt="hair">

<div id="tumbleweed">
    <img src="<s:url value='/img/tumbleweed.png' />" alt="tumbleweed" />
</div>

<script src="<s:url value='/js/fly.js' />"></script>
<script src="<s:url value='/js/hair.js' />"></script>
<script src="<s:url value='/js/tumbleweed.js' />"></script>