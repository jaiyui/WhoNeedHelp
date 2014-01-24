<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	$(".alert").hide();
});

var SignUp = {
	    check: function (id) {
	    	var verify = true;
	    	
	    	var value = $.trim($("#" + id)[0].value); 
	        if (value == '') {
	    		verify = false;
	        };

	        switch (id)
	        {
		        case "email":
		        	if (!IsEmail(value)) verify = false;
		        	break;
		        case "password":
		        	if (value.length < 8 || value.length > 15) verify = false;
			        if ($("#password")[0].value != $("#repeatPassword")[0].value) {
			            $("#repeatPassword")[0].focus();
			            $("#repeatPassword_alert").show();

			            verify = false;
			        }
		        	break;
	        }
	        if (!verify)
        	{
	            $("#" + id)[0].focus();
	            $("#" + id + "_alert").show();
        	} else
        		$("#" + id + "_alert").hide();
	        return verify;
	    },
	    validate: function () {
	        if (SignUp.check("username") == false) {
	            return false;
	        }
	        if (SignUp.check("email") == false) {
	            return false;
	        }
	        if (SignUp.check("password") == false) {
	            return false;
	        }
	        $("#registerForm")[0].submit();
	    }
	}
</script>
<body>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">

	<div class="page-header">
	    <h2>Register for WHO NEED HELP?</h2>
	</div>
	
	<form id="registerForm" class="form-horizontal" onbeforesubmit="return false" method="post" action="/session/register">    
		<fieldset>
        <div class="control-group">
            <label class="control-label" for="username">Username (Nick)</label>
            <div class="controls">
                <input class="input-xlarge" name="username" id="username" value="" type="text" />                
                <p class="help-block">(required)</p>
                <div class="alert" id="username_alert">
                    <strong>Warning!</strong> Please enter your desired user name
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="email">Email Address (ID)</label>
            <div class="controls">
                <input class="input-xlarge" name="email" id="email" value="" type="text" />                
                <p class="help-block">(required)</p>
                <div class="alert" id="email_alert">
                    <strong>Warning!</strong> Please enter your email
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
