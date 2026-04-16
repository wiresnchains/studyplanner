<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="<s:url value='/css/fly.css' />"/>

<div class="window" style="max-width: 800px; margin: 20px auto;">

  <div class="window-body">
    <h2 class="text-center mb-4">The Incident of 26</h2>

    <div class="alert alert-warning mb-3">
      <strong>ARCHIVED NOTICE:</strong> The following report has been preserved for awareness and prevention.
    </div>

    <section class="mb-4">
      <h5>Background Report</h5>
      <p>
        In early 2026, StudyPlanner experienced what is now internally referred to as
        <strong>The Incident of 26.</strong> What began as normal usage quickly escalated
        into widespread misuse of the platform for purposes far beyond its intended design.
      </p>
      <p>
        Users began creating entries unrelated to school, documenting personal conflicts, strange logs,
        and what some described as side activities. Over time, these entries became increasingly erratic,
        leading to the disappearance of our best developer.
      </p>
    </section>

    <section class="mb-4">
      <h5>The Escalation</h5>
      <p>
        Reports indicate that certain accounts were responsible for organizing and spreading
        this behavior across multiple users. Tasks were no longer tasks they became messages,
        coded notes, and unexplained references that staff could not fully interpret.
      </p>
      <p>
        Moderation efforts were deployed, but by the time action was taken, much of the
        activity had already spread. Several accounts disappeared shortly after, leaving
        behind incomplete data and unanswered questions.
      </p>
    </section>

    <section class="mb-4">
      <h5>Current Status</h5>
      <p>
        To this day, the individuals responsible for initiating and spreading the incident
        <strong>have not been identified</strong>. Investigations are still ongoing, and the case
        remains open.
      </p>
      <p>
        While the system has since been stabilized, traces of the incident can still be found
        in archived logs. As a result, strict policies have been enforced to prevent anything
        similar from happening again.
      </p>
    </section>

    <section class="mb-4">
      <h5>Policy Reminder</h5>
      <p>
        StudyPlanner is strictly limited to <strong>school-related use only</strong>.
        Any attempt to use the platform for unrelated activities may be flagged and reviewed.
      </p>
      <p>
        These rules exist as a direct result of the Incident of 26.
      </p>
    </section>

    <hr />

    <div class="d-flex justify-content-between align-items-center">
      <p class="mb-0"><em>Some tasks should never have been written. - StudyPlanner</em></p>
    </div>
  </div>
</div>

<canvas id="fly-trail"></canvas>
<img id="fly" src="<s:url value='/img/fly.gif' />" alt="fly"/>
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