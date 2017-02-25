package controller;

import java.io.IOException;

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
		if(request.getParameter("dieValue") != ("")) {
			dieValue = Integer.parseInt(request.getParameter("dieValue"));
		} else {
			dieValue = -1;
		}
		
		String url = "";
		
		//create objects
		Die die1 = new Die();
		Die die2 = new Die();
		Die die3 = new Die();
		
		//access hidden textboxes from bet.jsp
		Tool tool = new Tool(Integer.parseInt(request.getParameter("currentRoll")), Integer.parseInt(request.getParameter("purse")), 0);
		
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
	if(dieValue != -1) {
		if(single.equals("on")) {
			if(dieValue==die1.getValue() || dieValue==die2.getValue() || dieValue==die3.getValue() ) {
				tool.addToPurse(singleBetAmount);
			} else {
				tool.subtractFromPurse(singleBetAmount);
			}
		}
	
	//HOW TO CALCULATE SCORE?
		if(triple.equals("on")) {
			if(dieValue==die1.getValue() && dieValue==die2.getValue() && dieValue==die3.getValue() ) {
				tool.addToPurse(tripleBetAmount*3);
			} else {
				tool.subtractFromPurse(tripleBetAmount*3);
			}
		}
	
	
	//HAVE TO SELECT A DIEVALUE TO RUN THIS WHEN YOU ONLY NEED THE SUM
		int sum = 0;
		sum = die1.getValue() + die2.getValue() + die3.getValue();
		if(big.equals("on")) {
			if(sum >= 11) {
				tool.addToPurse(bigBetAmount);
			} else {
				tool.subtractFromPurse(bigBetAmount);
			}
		}
		
	//HAVE TO SELECT A DIEVALUE TO RUN THIS WHEN YOU ONLY NEED THE SUM
		if(small.equals("on")) {
			if(sum <= 10) {
				tool.addToPurse(smallBetAmount);
			} else {
				tool.subtractFromPurse(smallBetAmount);
			}
		}
		
	//HAVE TO SELECT A DIEVALUE TO RUN THIS WHEN YOU ONLY NEED THE SUM
	//SUM OUTSIDE THE RANGE OF 8 TO 12?
		if(field.equals("on")) {
			if(sum >= 8 && sum <= 12) {
				tool.addToPurse(fieldBetAmount);
			} else {
				tool.subtractFromPurse(fieldBetAmount);
			}
		}

	}	
	
		
		//initialize output
		url = "/roll.jsp";
		
		//add values to request objects to pass to the destination
		request.setAttribute("die1", die1);
		request.setAttribute("die2", die2);
		request.setAttribute("die3", die3);
		request.setAttribute("tool", tool);
		
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
