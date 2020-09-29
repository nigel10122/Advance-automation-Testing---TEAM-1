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


@WebServlet("/ManagerEventListServlet")
public class ManagerEventListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ManagerEventListServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int selectedEventIndex;
	
		ArrayList<Event> eventInDB = new ArrayList<Event>();
		Event selectedEvent = new Event();
		HttpSession session = request.getSession();
		if (request.getParameter("radioEvent")!=null) {
			selectedEventIndex = Integer.parseInt(request.getParameter("radioEvent")) - 1;
			eventInDB=EventDAO.ListSpecificEvent(); 
			 selectedEvent.SetEvent(eventInDB.get(selectedEventIndex).getEventid(), 
									 eventInDB.get(selectedEventIndex).getEventname(), 
									 eventInDB.get(selectedEventIndex).getEventdate(), 
									 eventInDB.get(selectedEventIndex).getStarttime(),
									 eventInDB.get(selectedEventIndex).getDuration(),
									 eventInDB.get(selectedEventIndex).getLocation(),
									 eventInDB.get(selectedEventIndex).getNumberofattendees(),
									 eventInDB.get(selectedEventIndex).getCapacity(),
									 eventInDB.get(selectedEventIndex).getEventcoordinator(),
									 eventInDB.get(selectedEventIndex).getType(),
									 eventInDB.get(selectedEventIndex).getEstattendees());
			session.setAttribute("EVENTS", selectedEvent);
			response.sendRedirect("managerlistspecificevent.jsp");					
		}
		else  // determine if Submit button was clicked without selecting a company
			if (request.getParameter("ListSelectedEventButton")!=null) {
				String errorMsgs =  "Please select a company";
				session.setAttribute("errorMsgs",errorMsgs);
				 response.sendRedirect("managereventsummary.jsp");				
			}
		
		
	}

}
