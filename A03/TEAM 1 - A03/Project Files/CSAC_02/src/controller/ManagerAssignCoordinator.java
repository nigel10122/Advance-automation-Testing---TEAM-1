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
import data.ReservationDAO;
import data.UserDAO;
import model.Event;
import model.Reservation;
import model.User;
import util.ConnectionPro;


@WebServlet("/ManagerAssignCoordinator")
public class ManagerAssignCoordinator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ManagerAssignCoordinator() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	/*	String eventname = request.getParameter("eventname");
		String eventdate = request.getParameter("eventdate");
		String starttime = request.getParameter("starttime");
		String duration = request.getParameter("duration");
		String location = request.getParameter("location");
		String numberofattendees = request.getParameter("numberofattendees");
		String capacity = request.getParameter("capacity");
		
		String type = request.getParameter("type");
		String estattendees = request.getParameter("estattendees"); */
	
		
		//action=AssignCoordinator
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		String availability = "Unavailable";
		String eventcoordinator = request.getParameter("eventcoordinator");
		HttpSession successfullsession = request.getSession();
		HttpSession errorsession = request.getSession();
		String successmessage = "Coordinator Assigned Succesfully";
		
		Event event = new Event();
	
	
		event.setEventcoordinator(eventcoordinator);
		event.setEventid(eventid);

		
	try
		{
			EventDAO modifyevent = new EventDAO(ConnectionPro.getConnection());
			if(modifyevent.AssignCoordinator(event))
			{	
				UserDAO updateuser = new UserDAO(ConnectionPro.getConnection());
				User user = new User();
				user.setAvailability(availability);
				user.setFirstname(eventcoordinator.substring(1,5));
				updateuser.updateCoordinatorAvailability(user);
				response.sendRedirect("managersuccessmessage.jsp");
				successfullsession.setAttribute("successmessage", successmessage);	
			}
			else
				response.sendRedirect("managerassigneventcoordinator.jsp");
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	
	
	
	}		
				
}					
				

		
	


