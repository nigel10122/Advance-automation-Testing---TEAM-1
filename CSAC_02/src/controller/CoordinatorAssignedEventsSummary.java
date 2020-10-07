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


@WebServlet("/CoordinatorAssignedEventsSummary")
public class CoordinatorAssignedEventsSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public CoordinatorAssignedEventsSummary() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "coordinatorhome.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		String eventcoordinator = request.getParameter("eventcoordinator");
		String eventdate = request.getParameter("eventdate");   
		String starttime = request.getParameter("starttime");
		Event event = new Event();
		event.setEventdate(eventdate);
		event.setStarttime(starttime);
		event.setEventcoordinator(eventcoordinator);
		HttpSession session = request.getSession();
		HttpSession errorsession = request.getSession();
		
		String eventdateError = event.validateDate(eventdate);
		String starttimeError = event.validateDateTime(eventdate, starttime);
		
		
		if(!eventdateError.equals("") || !starttimeError.equals("") )
		{
			errorsession.setAttribute("eventdateError", eventdateError);
			errorsession.setAttribute("starttimeError", starttimeError);
			requestDispatcher.forward(request, response);
		}
	else{//action=Coordinatorassignedevents
		ArrayList<Event> eventInDB = new ArrayList<Event>();
		eventInDB=EventDAO.CoordinatorAssignedevents(eventdate, starttime,eventcoordinator);
		session.setAttribute("EVENTS", eventInDB);
		response.sendRedirect("coordinatoreventsummary.jsp");
		session.removeAttribute("eventdateError");
		session.removeAttribute("starttimeError");
		}
	
		
		
		
	}

}
