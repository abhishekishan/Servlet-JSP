<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>                                                                     <%--page --%>
<%@page import="java.util.Date"%>                                                                   <%--import --%>
<%@ include file="Time.jsp" %>                                                                         <%--include --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Tags</title>
</head>
<body>
<jsp:include page="Abhi.jsp" flush="true" />                                                        <%--action --%>
	<%!int count = 10;%>                                                                                      <%--Declaration --%>
	<%
		out.println("The Number is " + count);                                                        
	%>                                                                                                                 <%--Scriptlet --%>

	<br>

	<%
		int num1 = 10;
		int num2 = 40;
		int num3 = num1 + num2;
		out.println("Scriplet Number is " + num3);
	%>                                                                                                                  <%--Scriptlet --%>

	<br>

	<%
		out.println("The expression number is ");
	%>
	<%
		int no1 = 10;
		int no2 = 10;
		int no3 = 20;
	%>                                                                                                                 <%--Scriptlet --%>
	<%=no1 * no2 + no3%>                                                                                     <%--Expression --%>

	<br>

	<a>Date is:</a>
	<%=new java.util.Date()%>                                                                                <%--Expression --%>

	<br>

	<%
		out.println("Your IP address is " + request.getRemoteAddr());
	%>                                                                                                                    <%--Scriptlet --%>
	<p>
		Today's date:
		<%=(new java.util.Date()).toLocaleString()%></p>                                                <%--Expression --%>

	<%-- This comment will not be visible in the page source --%>                                 <%--Comment --%>

</body>
</html>