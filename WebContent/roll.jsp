<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.Die" %>
<%@page import="model.Tool" %>
<%@ page import="java.text.NumberFormat" %>

<%
	//get inputs from request attribute
	Die die1 = (Die) request.getAttribute("die1");
	Die die2 = (Die) request.getAttribute("die2");
	Die die3 = (Die) request.getAttribute("die3");
	Tool tool = (Tool) request.getAttribute("tool");
	//Tool purse = (Tool) request.getAttribute("purse");
	
	
	//get number formats
	NumberFormat cf = NumberFormat.getCurrencyInstance();
	
	/* ahhhh
	int singleBetAmount = Integer.parseInt(request.getParameter("singleBetAmount"));
	int tripleBetAmount = Integer.parseInt(request.getParameter("tripleBetAmount"));
	int bigBetAmount = Integer.parseInt(request.getParameter("bigBetAmount"));
	int smallBetAmount = Integer.parseInt(request.getParameter("smallBetAmount"));
	int fieldBetAmount = Integer.parseInt(request.getParameter("fieldBetAmount"));
	*/
	
	/*just for testing
	System.out.println(singleBetAmount);
	System.out.println(tripleBetAmount);
	System.out.println(bigBetAmount);
	System.out.println(smallBetAmount);
	System.out.println(fieldBetAmount);
	*/
%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIST 4630 Chuck-a-Luck - Roll Page</title>
</head>
<body>
<h1>MIST 4630 Chuck-a-Luck - Roll Page</h1>

<p>
	Current Purse: <%= cf.format(tool.getPurse()) %>
</p>
<br>
<p>
	Current Roll: <%= tool.getCurrentRoll() %>
</p>
<br>
	
	<%	if(die1.getValue()==1) { %>
		<img src ="Dice-1.png">
	<% } %>
	<%	if(die1.getValue()==2) { %>
		<img src ="Dice-2.png">
	<% } %>
	<%	if(die1.getValue()==3) { %>
		<img src ="Dice-3.png">
	<% } %>
	<%	if(die1.getValue()==4) { %>
		<img src ="Dice-4.png">
	<% } %>
	<%	if(die1.getValue()==5) { %>
		<img src ="Dice-5.png">
	<% } %>
	<%	if(die1.getValue()==6) { %>
		<img src ="Dice-6.png">
	<% } %>
	
	
	<%	if(die2.getValue()==1) { %>
		<img src ="Dice-1.png">
	<% } %>
	<%	if(die2.getValue()==2) { %>
		<img src ="Dice-2.png">
	<% } %>
	<%	if(die2.getValue()==3) { %>
		<img src ="Dice-3.png">
	<% } %>
	<%	if(die2.getValue()==4) { %>
		<img src ="Dice-4.png">
	<% } %>
	<%	if(die2.getValue()==5) { %>
		<img src ="Dice-5.png">
	<% } %>
	<%	if(die2.getValue()==6) { %>
		<img src ="Dice-6.png">
	<% } %>
	
	<%	if(die3.getValue()==1) { %>
		<img src ="Dice-1.png">
	<% } %>
	<%	if(die3.getValue()==2) { %>
		<img src ="Dice-2.png">
	<% } %>
	<%	if(die3.getValue()==3) { %>
		<img src ="Dice-3.png">
	<% } %>
	<%	if(die3.getValue()==4) { %>
		<img src ="Dice-4.png">
	<% } %>
	<%	if(die3.getValue()==5) { %>
		<img src ="Dice-5.png">
	<% } %>
	<%	if(die3.getValue()==6) { %>
		<img src ="Dice-6.png">
	<% } %>

<br>

<form name="rollAgain" action="betAgain" method="get">
	<input type="submit" name="submit" value="Place Bet" />
</form>

<form name="quit" action="quitGame" method="get">
	<input type="submit" name="quit" value="Quit" />
</form>

<!-- Hidden Textboxes to store amounts -->
		<input type="hidden" name="purse" value="<%= tool.getPurse() %>"/>
		<input type="hidden" name="currentRoll" value="<%= tool.getCurrentRoll() %>"/>
	

</body>
</html>