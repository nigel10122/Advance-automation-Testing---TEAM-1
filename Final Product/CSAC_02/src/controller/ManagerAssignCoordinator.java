package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import data.EventDAO;
import model.Event;


import util.ConnectionPro;


@WebServlet("/ManagerAssignCoordinator")
public class ManagerAssignCoordinator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ManagerAssignCoordinator() {
        super();
        
    }


    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//action=AssignCoordinator
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		String eventcoordinator = request.getParameter("eventcoordinator");
		HttpSession successfullsession = request.getSession();
		String successmessage = "Coordinator Assigned Succesfully";
		
		Event event = new Event();
		
		event.setEventcoordinator(eventcoordinator);
		event.setEventid(eventid);
		

		
			    EventDAO modifyevent = new EventDAO(ConnectionPro.getConnection());
		
				modifyevent.AssignCoordinator(event);
				response.sendRedirect("managersuccessmessage.jsp");
				successfullsession.setAttribute("successmessage", successmessage);	
			
		
	
	
	
	
	}		
				
}					
				

		
	

