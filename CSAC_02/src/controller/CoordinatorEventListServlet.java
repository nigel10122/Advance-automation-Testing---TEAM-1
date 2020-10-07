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


@WebServlet("/CoordinatorEventListServlet")
public class CoordinatorEventListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CoordinatorEventListServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Event> eventInDB = new ArrayList<Event>();
		Event selectedEvent = new Event();
		HttpSession session = request.getSession();

			 	//action=listSpecificEvent
				eventInDB=EventDAO.ListSpecificEvent(request.getParameter("eventid"));
				selectedEvent.SetEvent(	eventInDB.get(0).getEventid(), 
						 eventInDB.get(0).getEventname(), 
						 eventInDB.get(0).getEventdate(), 
						 eventInDB.get(0).getStarttime(),
						 eventInDB.get(0).getDuration(),
						 eventInDB.get(0).getLocation(),
						 eventInDB.get(0).getNumberofattendees(),
						 eventInDB.get(0).getCapacity(),
						 eventInDB.get(0).getEventcoordinator(),
						 eventInDB.get(0).getType(),
						 eventInDB.get(0).getEstattendees());
				session.setAttribute("EVENTS", selectedEvent);
				response.sendRedirect("coordinatorlistspecificevent.jsp");	
	}
}
