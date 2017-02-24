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
		String url = "";
		
		//create objects
		Die die1 = new Die();
		Die die2 = new Die();
		Die die3 = new Die();
		
		//access hidden textboxes from bet.jsp
		Tool tool = new Tool(Integer.parseInt(request.getParameter("currentRoll")), Integer.parseInt(request.getParameter("purse")), 0);
		
		//tool.increment();
		
		/*
		//get input from bet.jsp
		//request.getParameter("")
		int singleBetAmount = Integer.parseInt(request.getParameter("singleBetAmount"));
		//add amount to purse and set purse IF roll is a win?
		amount += singleBetAmount;
		
		int tripleBetAmount = Integer.parseInt(request.getParameter("tripleBetAmount"));
		//add amount to purse
		
		int bigBetAmount = Integer.parseInt(request.getParameter("bigBetAmount"));
		//add amount to purse
		
		int smallBetAmount = Integer.parseInt(request.getParameter("smallBetAmount"));
		//add amount to purse
		
		int fieldBetAmount = Integer.parseInt(request.getParameter("fieldBetAmount"));
		//add amount to purse
		
		*/
		
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
