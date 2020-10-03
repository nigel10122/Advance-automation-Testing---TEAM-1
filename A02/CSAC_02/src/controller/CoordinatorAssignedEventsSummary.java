package controller;

import java.io.IOException;
import java.util.ArrayList;

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
		String eventcoordinator = request.getParameter("eventcoordinator");
		String eventdate = request.getParameter("eventdate");   
		String starttime = request.getParameter("starttime");
		Event event = new Event();
		event.setEventdate(eventdate);
		event.setStarttime(starttime);
		event.setEventcoordinator(eventcoordinator);
		HttpSession session = request.getSession();

		//action=Coordinatorassignedevents
		ArrayList<Event> eventInDB = new ArrayList<Event>();
		if (!eventdate.equals("") && !starttime.equals(""))
		{
				eventInDB=EventDAO.CoordinatorAssignedevents(eventdate, starttime,eventcoordinator);
				session.setAttribute("EVENTS", eventInDB);
				session.removeAttribute("event");
				response.sendRedirect("coordinatoreventsummary.jsp");
		}
		else {
			session.setAttribute("event", event);
			response.sendRedirect("coordinatorhome.jsp");				
		}
		
		
		
	}

}
