package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tool;

/**
 * Servlet implementation class BetServlet
 */
@WebServlet({ "/BetServlet", "/playGame", "/betAgain" })
public class BetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String action = request.getParameter("submit");
			
		if(action.equals("Play")) {
			//Tool currentRoll = new Tool();
			//get inputs from index.jsp
			Tool tool = new Tool(Integer.parseInt(request.getParameter("currentRoll")), Integer.parseInt(request.getParameter("purse")), 0);
			
			//Tool purse = new Tool();
			String url = "";	
			
			tool.increment();
			
			//initialize output
			url="/bet.jsp";
					
			//add values to request objects to pass to the destination
			request.setAttribute("tool", tool);
			
			//send control to next component
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} else if(action.equals("Place Bet")) {
				
			
			int currentRoll = Integer.parseInt(request.getParameter("currentRoll"));
				int purse = Integer.parseInt(request.getParameter("purse"));
				
				Tool tool = new Tool(currentRoll, purse, 0);
				
				tool.increment();
				String url = "";
				url = "/bet.jsp";
				
				request.setAttribute("tool", tool);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
