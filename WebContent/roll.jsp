<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.Die" %>
<%@page import="model.Tool" %>
<%@ page import="java.text.NumberFormat" %>

<%
	//get inputs from request attribute
	Tool tool = (Tool) request.getAttribute("tool");
	
	//get number formats
	NumberFormat cf = NumberFormat.getCurrencyInstance();
	
	//create die array to store the 3 dice
	Die[] dieArray = new Die[3];
	dieArray[0] = (Die) request.getAttribute("die1");
	dieArray[1] = (Die) request.getAttribute("die2");
	dieArray[2] = (Die) request.getAttribute("die3");
	
%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link type = "text/css" rel = "stylesheet" href = "style.css" />
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIST 4630 Chuck-a-Luck - Roll Page</title>
</head>
<body>
<h1>MIST 4630 Chuck-a-Luck - Roll Page</h1>

<p id="info">
	Current Purse: <%= cf.format(tool.getPurse()) %>
	<br>
</p>

<p id="info">
	Current Roll: <%= tool.getCurrentRoll() %>
</p>
<br>

	 <%
	for(int i = 0; i < 3; i++) {	
		if(dieArray[i].getValue()==1) { %>
		<img src ="Dice-1.png">
	 <%  } 
		if(dieArray[i].getValue()==2) { %>
		<img src ="Dice-2.png">
	 <% } 
		if(dieArray[i].getValue()==3) { %>
		<img src ="Dice-3.png">
	 <% } 
		if(dieArray[i].getValue()==4) { %>
		<img src ="Dice-4.png">
	 <% } 
		if(dieArray[i].getValue()==5) { %>
		<img src ="Dice-5.png">
	 <% } 
		if(dieArray[i].getValue()==6) { %>
		<img src ="Dice-6.png">
	 <% } 
		} 								%>

<br>


<%	String singleOutcome = (String) request.getAttribute("singleOutcome");
	String tripleOutcome = (String) request.getAttribute("tripleOutcome");
	String bigOutcome = (String) request.getAttribute("bigOutcome");
	String smallOutcome = (String) request.getAttribute("smallOutcome");
	String fieldOutcome = (String) request.getAttribute("fieldOutcome");
	String totalOutcome = (String) request.getAttribute("totalOutcome");
	
%>

<br>

<% if(!singleOutcome.equals("Did not play")) { %>
	<%= singleOutcome %> 
	<br>
<% } %>

<% if(!tripleOutcome.equals("Did not play")) { %>
	<%= tripleOutcome %>
	<br>
<% } %>

<% if(!bigOutcome.equals("Did not play")) { %>
	<%= bigOutcome %>
	<br>
<% } %>

<% if(!smallOutcome.equals("Did not play")) { %>
	<%= smallOutcome %>
	<br>
<% } %>

<% if(!fieldOutcome.equals("Did not play")) { %>
	<%= fieldOutcome %>
	<br>
<% } %>

<p id="total"> <%= totalOutcome %> </p>

<br>

<% if(tool.getPurse() > 0) { %>	

<form name="rollAgain" action="betAgain" method="get">
	<input id="button" type="submit" name="submit" value="Place Bet" />
	
<% } %>
	
	<!-- Hidden Textboxes to store amounts -->
		<input type="hidden" name="purse" value="<%= tool.getPurse() %>" />
		<input type="hidden" name="currentRoll" value="<%= tool.getCurrentRoll() %>" />
		
</form>

<form name="quit" action="quitGame" method="get">
	<input id="button" type="submit" name="quit" value="Quit" />
	
	<!-- Hidden Textboxes to store amounts -->
		<input type="hidden" name="purse" value="<%= tool.getPurse() %>" />
		<input type="hidden" name="currentRoll" value="<%= tool.getCurrentRoll() %>" />
		
</form>
	

</body>
</html>