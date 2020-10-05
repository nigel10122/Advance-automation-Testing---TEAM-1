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
import data.ReservationDAO;
import model.Event;
import model.Reservation;


@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EventServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destination = "welcome.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String eventdate = request.getParameter("eventdate");   
		String starttime = request.getParameter("starttime");
		Event event = new Event();
		HttpSession session = request.getSession();
		
		String eventdateError = event.validateDate(eventdate);
		String eventtimeError = event.validateDateTime(eventdate,starttime);
		
		ArrayList<Reservation> eventInDB = new ArrayList<Reservation>();
		
	
		if(!eventdateError.equals("") || !eventtimeError.equals(""))
		{
			session.setAttribute("eventdateError", eventdateError);
			session.setAttribute("eventtimeError", eventtimeError);
			requestDispatcher.forward(request, response);
			
		}	//action=GetPassengerEvent
		if (!eventdate.equals("") && !starttime.equals(""))
		{
				eventInDB=ReservationDAO.getPassengerEvents(eventdate, starttime, firstname, lastname);
				session.setAttribute("EVENTS", eventInDB);
				session.removeAttribute("event");
				response.sendRedirect("eventsummary.jsp");
		}
		else {
			session.setAttribute("event", event);
			response.sendRedirect("welcome.jsp");				
		}
		
		
		
	}

}
