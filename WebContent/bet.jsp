<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@page import="model.Tool" %>
<%@page import="java.text.NumberFormat" %>

    <%
    	
    	//get inputs from request attribute
    	Tool tool = (Tool) request.getAttribute("tool");
    	
    	//get number formats
    	NumberFormat cf = NumberFormat.getCurrencyInstance();
    	
    	
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link type = "text/css" rel = "stylesheet" href = "style.css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIST 4630 Chuck-a-Luck - Bet Page</title>
</head>
<body>
<h1> MIST 4630 Chuck-a-Luck - Bet Page </h1>

<p id="info">
	Current Purse: <%= cf.format(tool.getPurse()) %>
</p>

<p id="info">
	Current Roll: <%= tool.getCurrentRoll() %>
</p>

<form name="betPage" action="placeBet" method="get">
	<table border="1" frame="hsides" rules="rows" align="center">
	
	<thead>
		<tr>
			<td><strong>Type</strong></td>
			<td><strong>Description</strong></td>
			<td><strong>Wager</strong></td>
			<td><strong>Odds</strong></td>
		</tr>
	</thead>
	
		<tbody>
			<tr>
				<td>
					<input type="checkbox" name="single"/> <label> Single </label>
				</td>
				<td><label>Die Value: </label>
					<select name="dieValue" id="dieValue">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
					</select>
				</td>
				<td>Bet Amount: <div>
					<input type="text" name="singleBetAmount" value=""/> </div>
				</td>
				<td>
					1 die, 1 to 1; 2 dice, 2 to 1; 3 dice, 10 to 1
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="triple"/> <label> Any Triple </label>
				</td>
				<td>
					Any of the triples
				</td>
				<td>Bet Amount: <div>
					<input type="text" name="tripleBetAmount" value=""/> </div>
				</td>
				<td>
					30 to 1
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="big"/> <label> Big </label>
				</td>
				<td>
					Sum of Dice 11 or higher (except triple)
				</td>
				<td>Bet Amount: <div>
					<input type="text" name="bigBetAmount" value=""/> </div>
				</td>
				<td>
					1 to 1
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="small"/> <label> Small </label>
				</td>
				<td>
					Sum of Dice 10 or lower (except triple)
				</td>
				<td>Bet Amount: <div>
					<input type="text" name="smallBetAmount" value=""/> </div>
				</td>
				<td>
					1 to 1
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="field"/> <label> Field </label>
				</td>
				<td>
					Sum outside the range of 8 to 12
				</td>
				<td>Bet Amount: <div>
					<input type="text" name="fieldBetAmount" value=""/> </div>
				</td>
				<td>
					1 to 1
				</td>
			</tr>
		</tbody>
		
	</table>
	
		<!-- Hidden Textboxes to store amounts -->
		<input type="hidden" name="purse" value="<%= tool.getPurse() %>"/>
		<input type="hidden" name="currentRoll" value="<%= tool.getCurrentRoll() %>"/>
		
		<br> 
		
		<div style="text-align:center;">
			<input id="button" type="submit" name="submit" value="Place Bet"/>
		</div>
		
</form>
</body>
</html>