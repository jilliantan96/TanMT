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
		
		//get inputs from bet.jsp
		String single;
		if(request.getParameter("single") == (null)) {
			single = "off";
		} else {
			single = request.getParameter("single");
		}
		
		int singleBetAmount;
		
		if(request.getParameter("singleBetAmount") == ("")) {
			singleBetAmount = 0;
		} else {
			singleBetAmount = Integer.parseInt(request.getParameter("singleBetAmount"));
		}
		
		/*int tripleBetAmount = Integer.parseInt(request.getParameter("tripleBetAmount"));
		
		int bigBetAmount = Integer.parseInt(request.getParameter("bigBetAmount"));
		
		int smallBetAmount = Integer.parseInt(request.getParameter("smallBetAmount"));
		
		int fieldBetAmount = Integer.parseInt(request.getParameter("fieldBetAmount")); */
		
	if(dieValue != -1) {
		if(single.equals("on")) {
			if(dieValue==die1.getValue() || dieValue==die2.getValue() || dieValue==die3.getValue() ) {
				tool.addToPurse(singleBetAmount);
			} else {
				tool.subtractFromPurse(singleBetAmount);
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
