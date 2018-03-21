<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Action Tag & others</title>
</head>
<body>

<a>This is after forward page</a>
	<h4>
		Current time is from abhi.jsp file:
		<%=new Date()%></h4>

	<jsp:useBean id="Harry" class="demotest.TestBean" />
	<jsp:setProperty name="Harry" property="msg" value="Khushi" />
	<jsp:getProperty name="Harry" property="msg" />
	
	<jsp:plugin type="bean" code="Student.class" codebase="demotest.Student">
  <jsp:params>
     <jsp:param name="id" value="5" />
     <jsp:param name="name" value="guru" />
  </jsp:params>
</jsp:plugin>
	

</body>
</html>