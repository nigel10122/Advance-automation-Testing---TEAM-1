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


@WebServlet("/PassengerEventTypeServlet")
public class PassengerEventTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PassengerEventTypeServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destination = "passengersearchevent.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		String eventdate = request.getParameter("eventdate");   
		String starttime = request.getParameter("starttime");
		String eventtype = request.getParameter("type");
		Event event = new Event();
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
		if (!eventdate.equals("") && !starttime.equals(""))
		{
				eventInDB=EventDAO.geteventsbasedonshowtype(eventdate, starttime, eventtype);
				session.setAttribute("EVENTS", eventInDB);
				session.removeAttribute("event");
				response.sendRedirect("passengerlistallevents.jsp");
		}
		else {
			session.setAttribute("event", event);
			requestDispatcher.forward(request, response);				
		}
		
	
		
	}

}
