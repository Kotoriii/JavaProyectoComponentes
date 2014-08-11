

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<div style="color: red">
		<html:errors />
	</div>
	<div style="margin-left: auto; margin-right:auto; margin-top: 10%;width:20%; height: 30%; border-radius:20px; padding:20px; background-color: silver;">
		<html:form action="/Login">
            Nombre de Usuario : <html:text name="LoginForm"
				property="userName" />
			<br>
            Contrase_a  : <html:password name="LoginForm"
				property="password" />
			<br>
			<html:submit value="Login" />
		</html:form>
	</div>
</body>
</html>
