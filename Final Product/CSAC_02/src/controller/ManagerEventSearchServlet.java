package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.EventDAO;
import model.Event;


@WebServlet("/ManagerEventSearchServlet")
public class ManagerEventSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ManagerEventSearchServlet() {
        super();
      
    }





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destination = "managerhome.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		
		String eventdate = request.getParameter("eventdate");   
		String starttime = request.getParameter("starttime");
		Event event = new Event(eventdate,starttime);
		HttpSession session = request.getSession();


		String eventdateError = event.validateDate(eventdate);
		String eventtimeError = event.validateDateTime(eventdate,starttime);
		
		ArrayList<Event> eventInDB = new ArrayList<Event>();
		
		if(!eventdateError.equals("") || !eventtimeError.equals(""))
		{
			session.setAttribute("eventdateError", eventdateError);
			session.setAttribute("eventtimeError", eventtimeError);
			requestDispatcher.forward(request, response);
			
		}
		else
		{
				eventInDB=EventDAO.getAllevents(eventdate, starttime);
				session.setAttribute("EVENTS", eventInDB);
				session.removeAttribute("event");
				response.sendRedirect("managereventsummary.jsp");
		}
		
		
		
		
	}

}