<!doctype html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
        <link rel="stylesheet" href="<s:url value='/css/base.css' />" />
        <link rel="stylesheet" href="<s:url value='/css/sidebar.css' />" />
        <link rel="stylesheet" href="<s:url value='/css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<s:url value='/css/timer.css' />" />
        <title><tiles:insertAttribute name="title" /> - Studyplanner</title>
    </head>
    <body>
        <main class="d-flex min-vh-100">
            <div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary" bg-light style="width: 280px">
				<!-- TITLE + TIMER BUTTON -->
				<div class="d-flex align-items-center justify-content-between mb-3">
					<a href="<s:url value='/' />"
						class="d-flex align-items-center link-body-emphasis text-decoration-none">
						<span class="fs-4">Studyplanner</span>
					</a>

					<button id="toggleBtn" class="btn btn-outline-primary">timer</button>
				</div>

			<hr />

			<ul class="nav nav-pills flex-column mb-auto">
				<li class="nav-item"><a href="<s:url value='/' />"
					class="nav-link"> Home </a></li>
			</ul>

			<hr />

			<s:if test="#session.currentAccountDTO != null">
				<div class="dropdown">
					<a href="#"
						class="d-flex align-items-center link-body-emphasis text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> <s:property
							value="#session.currentAccountDTO.username" /> <s:if
							test="#session.unreadMailboxMessageCount > 0">
							<span
								class="position-absolute top-0 start-100 translate-middle p-1 bg-danger border border-light rounded-circle">
								<span class="visually-hidden">New messages</span>
							</span>
						</s:if>
					</a>
					<ul class="dropdown-menu text-small shadow">
						<li><a class="dropdown-item d-flex align-items-center gap-2"
							href="<s:url value="/mailbox/" />"> <s:if
									test="#session.unreadMailboxMessageCount > 0">
									<span class="badge text-bg-danger"><s:property
											value="#session.unreadMailboxMessageCount" /></span>
								</s:if> Mailbox
						</a></li>

						<li><a class="dropdown-item" href="#">Settings</a></li>
						<li><hr class="dropdown-divider" /></li>
						<li><a class="dropdown-item"
							href="<s:url value='/auth/logout' />">Log-out</a></li>
					</ul>
				</div>
			</s:if>
			<s:else>
				<div class="dropdown">
					<a href="#"
						class="d-flex align-items-center link-body-emphasis text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> Account </a>
					<ul class="dropdown-menu text-small shadow">
						<li><a class="dropdown-item" href="<s:url value='/login' />">Login</a></li>
						<li><a class="dropdown-item"
							href="<s:url value='/register' />">Register</a></li>
					</ul>
				</div>
			</s:else>
		</div>

		<div class="container-fluid p-4">
			<h1 class="h3 mb-4">
				<tiles:insertAttribute name="title" />
			</h1>

			<tiles:insertAttribute name="body" ignore="true" />

			<tags:actionMessages />
		</div>

		<div id="timerBox" class="card shadow">
			<div class="card-body text-center">

				<div id="mode" class="text-muted small mb-2">Focus</div>

				<div class="circle" id="circle">
					<svg width="160" height="160">
							<circle class="bg" cx="80" cy="80" r="70"></circle>
							<circle class="progress" cx="80" cy="80" r="70"></circle>
						</svg>
					<div id="time"></div>
				</div>

				<div class="mt-3 d-flex justify-content-center gap-2">
					<button class="btn btn-secondary btn-sm" onclick="resetTimer()">Reset</button>
				</div>

			</div>
		</div>
	</main>

	<script type="text/javascript"
		src="<s:url value='/js/popper.min.js' />"></script>
	<script type="text/javascript"
		src="<s:url value='/js/bootstrap.min.js' />"></script>
	<script type="text/javascript" 
		src="<s:url value='/js/timer.js' />"></script>
</body>
</html>
