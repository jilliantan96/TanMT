package controller;

import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Die;
import model.Tool;

/**
 * Servlet implementation class RollServlet
 */
@WebServlet({ "/RollServlet", "/placeBet" })
public class RollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//if no die value was selected
		int dieValue;
			dieValue = Integer.parseInt(request.getParameter("dieValue"));
		
		NumberFormat cf = NumberFormat.getCurrencyInstance();
			
		String url = "";
		
		//create objects
		Die die1 = new Die();
		Die die2 = new Die();
		Die die3 = new Die();
		
		//testing purposes
		//die1.setValue(6);
		//die2.setValue(6);
		//die3.setValue(6);
		
		//access hidden textboxes from bet.jsp
		Tool tool = new Tool(Integer.parseInt(request.getParameter("currentRoll")), Integer.parseInt(request.getParameter("purse")));
		
	//check if the boxes are checked
	String single;
		if(request.getParameter("single") == (null)) {
			single = "off";
		} else {
			single = request.getParameter("single");
		}
		
	String triple;
		if(request.getParameter("triple") == (null)) {
			triple = "off";
		} else {
			triple = request.getParameter("triple");
		}
		
	String big;
		if(request.getParameter("big") == (null)) {
			big = "off";
		} else {
			big = request.getParameter("big");
		}
		
	String small;
		if(request.getParameter("small") == (null)) {
			small = "off";
		} else {
			small = request.getParameter("small");
		}
		
	String field;
		if(request.getParameter("field") == (null)) {
			field = "off";
		} else {
			field = request.getParameter("field");
		}
		
	//see if there is a wager amount
		int singleBetAmount;
			if(request.getParameter("singleBetAmount") == ("")) {
				singleBetAmount = 0;
			} else {
				singleBetAmount = Integer.parseInt(request.getParameter("singleBetAmount"));
		}
		
		int tripleBetAmount;
			if(request.getParameter("tripleBetAmount") == ("")) {
				tripleBetAmount = 0;
			} else {
				tripleBetAmount = Integer.parseInt(request.getParameter("tripleBetAmount"));
		}
			
		int bigBetAmount;
			if(request.getParameter("bigBetAmount") == ("")) {
				bigBetAmount = 0;
			} else {
				bigBetAmount = Integer.parseInt(request.getParameter("bigBetAmount"));
		}
			
		int smallBetAmount;
			if(request.getParameter("smallBetAmount") == ("")) {
				smallBetAmount = 0;
			} else {
				smallBetAmount = Integer.parseInt(request.getParameter("smallBetAmount"));
		}
			
		int fieldBetAmount;
			if(request.getParameter("fieldBetAmount") == ("")) {
				fieldBetAmount = 0;
			} else {
				fieldBetAmount = Integer.parseInt(request.getParameter("fieldBetAmount")); 
		}
			
		//runs only if they selected a die value to bet on & adds/subtracts from purse accordingly
		
		int total = 0;
		String totalOutcome = "";
			
		String singleOutcome = "Did not play";
		String tripleOutcome = "Did not play";
		String bigOutcome = "Did not play";
		String smallOutcome = "Did not play";
		String fieldOutcome = "Did not play";
			
		int singleCount = 0;
		
		if(single.equals("on")) {
			if(singleBetAmount != 0) {
				if(dieValue==die1.getValue()) {
					singleCount++;
				}
				if(dieValue==die2.getValue()) {
					singleCount++;
				}
				if(dieValue==die3.getValue()) {
					singleCount++;
				}
		switch(singleCount) {
		case 1:
			tool.addToPurse(singleBetAmount);
			singleOutcome = "Single Bet - Winner - winnings: " + cf.format(singleBetAmount);
			total += singleBetAmount;
			break;
		case 2:
			tool.addToPurse(singleBetAmount*2);
			singleOutcome = "Single Bet - Winner - winnings: " + cf.format(singleBetAmount*2);
			total += singleBetAmount*2;
			break;
		case 3:
			tool.addToPurse(singleBetAmount*10);
			singleOutcome = "Single Bet - Winner - winnings: " + cf.format(singleBetAmount*10);
			total += singleBetAmount*10;
			break;
		default:
			tool.subtractFromPurse(singleBetAmount);
			singleOutcome = "Single Bet - Loser - Losses: -" + cf.format(singleBetAmount);
			total -= singleBetAmount;
			break;
		}
			
					
					
	}
} 
		
		if(triple.equals("on")) {
			if(tripleBetAmount != 0) {
				if(dieValue==die1.getValue() && dieValue==die2.getValue() && dieValue==die3.getValue() ) {
					tool.addToPurse(tripleBetAmount*30);
					tripleOutcome = "Triple Bet - Winner - winnings: " + cf.format((tripleBetAmount*30));
					total += (tripleBetAmount*30);
				} else {
					tool.subtractFromPurse(tripleBetAmount);
					tripleOutcome = "Triple Bet - Loser - losses: -" + cf.format(tripleBetAmount);
					total -= tripleBetAmount;
				}
			}
		}
		
		
			int sum = 0;
			sum = die1.getValue() + die2.getValue() + die3.getValue();
			
		if(big.equals("on")) {
			if(bigBetAmount != 0) {	
				if(sum >= 11) {
					tool.addToPurse(bigBetAmount);
					bigOutcome = "Big Bet - Winner - winnings: " + cf.format(bigBetAmount);
					total += bigBetAmount;
				} else {
					tool.subtractFromPurse(bigBetAmount);
					bigOutcome = "Big Bet - Loser - losses: -" + cf.format(bigBetAmount);
					total -= bigBetAmount;
				}
			}
		}
		

		if(small.equals("on")) {
			if(smallBetAmount != 0) {
				if(sum <= 10) {
					tool.addToPurse(smallBetAmount);
					smallOutcome = "Small Bet - Winner - winnings: " + cf.format(smallBetAmount);
					total += smallBetAmount;
				} else {
					tool.subtractFromPurse(smallBetAmount);
					smallOutcome = "Small Bet - Loser - losses: -" + cf.format(smallBetAmount);
					total -= smallBetAmount;
				}
			}
		}
		
	
		//SUM OUTSIDE THE RANGE OF 8 TO 12?
		if(field.equals("on")) {
			if(fieldBetAmount != 0) {
				if(sum >= 8 && sum <= 12) {
					tool.subtractFromPurse(fieldBetAmount);
					fieldOutcome = "Field Bet - Loser - Losses: -" + cf.format(fieldBetAmount);
					total -= fieldBetAmount;
				} else {
					tool.addToPurse(fieldBetAmount);
					fieldOutcome = "Field Bet - Winner - winnings: " + cf.format(fieldBetAmount);
					total += fieldBetAmount;
				}
			}
		}

		if(total > 0) {
			totalOutcome = "Total winnings from this roll: " + cf.format(total);
		} else if (total < 0) {
			totalOutcome = "Total losses from this roll: " + cf.format(total);
		} else {
			totalOutcome = "You broke even!";
		}
	
		
		//initialize output
		url = "/roll.jsp";
		
		//add values to request objects to pass to the destination
		request.setAttribute("die1", die1);
		request.setAttribute("die2", die2);
		request.setAttribute("die3", die3);
		request.setAttribute("tool", tool);
		
		request.setAttribute("singleOutcome", singleOutcome);
		request.setAttribute("tripleOutcome", tripleOutcome);
		request.setAttribute("bigOutcome", bigOutcome);
		request.setAttribute("smallOutcome", smallOutcome);
		request.setAttribute("fieldOutcome", fieldOutcome);
		request.setAttribute("totalOutcome", totalOutcome);
		
		//send control to next component
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
