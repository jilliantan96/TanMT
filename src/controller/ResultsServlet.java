package controller;

import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tool;

/**
 * Servlet implementation class ResultsServlet
 */
@WebServlet({ "/ResultsServlet", "/quitGame" })
public class ResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		
		//get inputs from index.jsp
		Tool tool = new Tool(Integer.parseInt(request.getParameter("currentRoll")), Integer.parseInt(request.getParameter("purse")));
		
		String url = "";	
		
		//initialize output
		url="/results.jsp";
		
		//if player lost all money or ended with less than he started with
		String msg = "";
		
		if(tool.getPurse() > 0 && tool.getPurse() < 1000) {
			msg = "Unfortunately, you lost more money than what you started with. Try again!.";
		} else if (tool.getPurse() < 0) {
			msg = "You are now in debt. You owe us " + cf.format(tool.getPurse()) + ".";
		} else if(tool.getPurse() == 0) {
			msg = "Sorry, you ran out of money. Come back when you have more!";
		} else if(tool.getPurse() == 1000) {
			msg = "You ended with the same amount that you started with. Please play again!";
		} else {
			msg = "Congratulations! You're a winner. Please play again.";
		}
				
		//add values to request objects to pass to the destination
		request.setAttribute("tool", tool);
		request.setAttribute("msg", msg);
		
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
