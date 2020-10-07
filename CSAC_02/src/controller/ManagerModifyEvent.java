package controller;

import java.io.IOException;


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

import util.ConnectionPro;


@WebServlet("/ManagerModifyEvent")
public class ManagerModifyEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ManagerModifyEvent() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//action=ModifyEvent
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		String eventname = request.getParameter("eventname");
		String eventdate = request.getParameter("eventdate");
		String starttime = request.getParameter("starttime");
		String duration = request.getParameter("duration");
		String location = request.getParameter("location");
		String numberofattendees = request.getParameter("numberofattendees");
		String capacity = request.getParameter("capacity");
		String eventcoordinator = request.getParameter("eventcoordinator");
		String type = request.getParameter("type");
		String estattendees = request.getParameter("estattendees");
	
		HttpSession successfullsession = request.getSession();
		String successmessage = "Event Modified Succesfully";
		
		Event eventmodel = new Event(eventid, eventname, eventdate,  starttime,  duration , location,  numberofattendees,  capacity,  eventcoordinator,  type, estattendees);
		EventDAO modifyevent = new EventDAO(ConnectionPro.getConnection());
		
	try
		{
			
			if(modifyevent.ModifyEvent(eventmodel))
			{
				response.sendRedirect("managersuccessmessage.jsp");
				successfullsession.setAttribute("successmessage", successmessage);	
			}
			else
				response.sendRedirect("managermodifyevent.jsp");
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	
	
	
	}		
				
}					
				

		
	


