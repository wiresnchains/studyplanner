<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <link rel="stylesheet" href="<s:url value='/css/base.css' />" />
    <link rel="stylesheet" href="<s:url value='/css/login.css' />"
    <link rel="stylesheet" href="<s:url value='/css/bootstrap.min.css' />" />
    <title><tiles:insertAttribute name="title" /> - Studyplanner</title>
</head>
<main class="d-flex align-items-center py-4 min-vh-100">
    <div class="w-100 m-auto" style="max-width: 400px;">
        <s:form action="register" namespace="/auth" class="loginForm mb-3">
            <h1 class="h3 mb-3 fw-normal">Register</h1>

            <div class="form-floating">
                <s:textfield
                    id="email"
                    name="form.email"
                    type="email"
                    required="true"
                    cssClass="form-control"
                    placeholder="john@example.com"
                />
                <label for="email">E-mail</label>
            </div>

            <div class="form-floating">
                <s:textfield
                    id="username"
                    name="form.username"
                    type="text"
                    required="true"
                    cssClass="form-control"
                    placeholder="John"
                />
                <label for="username">Username</label>
            </div>

            <div class="form-floating">
                <s:textfield
                    id="password"
                    name="form.password"
                    type="password"
                    required="true"
                    cssClass="form-control"
                    placeholder="Very secure password"
                />
                <label for="password">Password</label>
            </div>

            <div class="form-floating mb-3">
                <s:textfield
                    id="confirmPassword"
                    name="form.confirmPassword"
                    type="password"
                    required="true"
                    cssClass="form-control"
                    placeholder="Very secure password"
                />
                <label for="confirmPassword">Confirm password</label>
            </div>

            <div class="form-check mb-3">
                <s:checkbox id="agreeTos" name="form.agreeTos" required="true" cssClass="form-check-input" />
                <label for="agreeTos" class="form-check-label">
                    I agree with the
                    <a href="<s:url value='/terms-and-conditions' />" target="_blank">terms and conditions</a>
                </label>
            </div>

            <s:submit value="Register" cssClass="btn btn-primary w-100 py-2 mb-3" />

            <a href="<s:url value='/login' />">Log-in</a>
        </s:form>

        <tags:actionMessages />
    </div>
</main>
