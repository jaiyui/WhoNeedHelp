<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
$(document).ready(function() {

});
</script>
<body>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">

	<div class="page-header">
	    <h2>Profile</h2>
	</div>
	
	<form id="FellowsProfile" name="FellowsProfile" class="form-horizontal" onbeforesubmit="return false" method="post" action="/fellow/profile">    
		<fieldset>
        <div class="control-group">
            <label class="control-label" for="nickname">nickname (Nick)</label>
            <div class="controls">
                <input class="input-xlarge" name="nickname" id="nickname" value="" type="text" />                
                <p class="help-block">(required)</p>
                <div class="alert" id="nickname_alert">
                    <strong>Warning!</strong> Please enter your desired user name
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="id">Email Address (ID)</label>
            <div class="controls">
                <input class="input-xlarge" name="id" id="id" value="" type="text" />                
                <p class="help-block">(required)</p>
                <div class="alert" id="id_alert">
                    <strong>Warning!</strong> Please enter your valid email
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input class="input-xlarge" name="password" id="password" value="" type="password" />                
                <p class="help-block">(required, minimum 8 and maximum 15 characters)</p>
                <div class="alert" id="password_alert">
                    <strong>Warning!</strong> Please provide a valid password
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="repeatPassword">Repeat Password</label>
            <div class="controls">
                <input class="input-xlarge" name="repeatPassword" id="repeatPassword" value="" type="password" />                
                <div class="alert" id="repeatPassword_alert">
                    <strong>Warning!</strong> The password does not match
                </div>
            </div>
        </div>
        <p>By signing up, you accept terms of use and privacy policy.</p>
        <div class="form-actions">
            <input class="btn btn-primary btn-large" onclick="return SignUp.validate();" value="Register" type="submit" />        
        </div>
    </fieldset>
	</form>
	<jsp:include page="/WEB-INF/views/common/commonBodyBottom.jsp" />
</div>
</body>
<jsp:include page="/WEB-INF/views/common/commonFooter.jsp" />
