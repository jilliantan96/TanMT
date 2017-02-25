<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.Tool" %>
<%@page import="java.text.NumberFormat" %>
    
<%
	Tool tool = (Tool) request.getAttribute("tool");
	String msg = (String) request.getAttribute("msg");

	NumberFormat cf = NumberFormat.getCurrencyInstance(); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link type = "text/css" rel = "stylesheet" href = "style.css" />
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIST 4630 Chuck-a-Luck - Results Page</title>
</head>
<body>
<h1>MIST 4630 Chuck-a-Luck - Results Page</h1>

	<p id="final"> Final Purse: <%= cf.format(tool.getPurse()) %> </p>
	
	<p id="final"> Number of Rolls: <%= tool.getCurrentRoll() %> </p>
	
	<p id="final"> <%= msg %> </p>
	
		<a id="final" href = "index.jsp">Play Again!</a>

</body>
</html>