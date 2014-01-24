<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	$("#email").focusin(function() { if ($(this).val() == "member@whoneedhelp.com") $(this).val(""); });
	$("#email").focusout(function() { if ($(this).val() == "") $(this).val("member@whoneedhelp.com"); });

	$("#password").focusin(function() { if ($(this).val() == "whoneedhelp") $(this).val(""); });
	$("#password").focusout(function() { if ($(this).val() == "") $(this).val("whoneedhelp"); });
});
</script>
<body>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">

	<div class="page-header">
	    <h2>Register for INVO</h2>
	</div>
	
	<form id="registerForm" class="form-horizontal" onbeforesubmit="return false" method="post" action="/session/register">    <fieldset>
        <div class="control-group">
            <label class="control-label" for="name">Your Full Name</label>
            <div class="controls">
                <input class="input-xlarge" name="name" id="name" value="" type="text" />                <p class="help-block">(required)</p>
                <div class="alert" id="name_alert">
                    <strong>Warning!</strong> Please enter your full name
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="username">Username</label>
            <div class="controls">
                <input class="input-xlarge" name="username" id="username" value="" type="text" />                <p class="help-block">(required)</p>
                <div class="alert" id="username_alert">
                    <strong>Warning!</strong> Please enter your desired user name
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="email">Email Address</label>
            <div class="controls">
                <input class="input-xlarge" name="email" id="email" value="" type="text" />                <p class="help-block">(required)</p>
                <div class="alert" id="email_alert">
                    <strong>Warning!</strong> Please enter your email
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input class="input-xlarge" name="password" id="password" value="" type="password" />                <p class="help-block">(minimum 8 characters)</p>
                <div class="alert" id="password_alert">
                    <strong>Warning!</strong> Please provide a valid password
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="repeatPassword">Repeat Password</label>
            <div class="controls">
                <input class="input-xlarge" name="repeatPassword" id="repeatPassword" value="" type="password" />                <div class="alert" id="repeatPassword_alert">
                    <strong>Warning!</strong> The password does not match
                </div>
            </div>
        </div>
        <p>By signing up, you accept terms of use and privacy policy.</p>
        <div class="form-actions">
            <input class="btn btn-primary btn-large" onclick="return SignUp.validate();" value="Register" type="submit" />        </div>
    </fieldset>
	</form>
	<jsp:include page="/WEB-INF/views/common/commonBodyBottom.jsp" />
</div>
</body>
<jsp:include page="/WEB-INF/views/common/commonFooter.jsp" />
