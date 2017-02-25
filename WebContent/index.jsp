<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.Tool" %>
<%@page import="java.text.NumberFormat" %>

<%  Tool tool = new Tool(0, 1000, 0);

	NumberFormat cf = NumberFormat.getCurrencyInstance();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link type = "text/css" rel = "stylesheet" href = "style.css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIST 4630 Chuck-a-Luck Game</title>
</head>
<body>
<h1> MIST 4630 Chuck-a-Luck Game </h1>

	<p>
	Place a bet and try your luck!
	</p>
	
	<img src="Dice-5.png"/>
	<img src="Dice-3.png"/>
	<img src="Dice-2.png"/>
	
	<br>
	
	<p>
	You start with a stake of <%= cf.format(tool.getPurse()) %>.
	</p>
	
	<form name="play" action="playGame" method="get">
	<input type="submit" name="submit" value="Play" />
	
		<!-- Hidden Textboxes to store amounts -->
		<input type="hidden" name="purse" value="<%= tool.getPurse() %>"/>
		<input type="hidden" name="currentRoll" value="<%= tool.getCurrentRoll() %>"/>
		
	</form>

</body>
</html>