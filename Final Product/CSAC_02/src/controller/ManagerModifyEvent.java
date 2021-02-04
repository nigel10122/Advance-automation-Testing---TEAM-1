package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.EventDAO;
import model.Event;
import util.CheckErrorMsgs;
import util.ConnectionPro;


@WebServlet("/ManagerModifyEvent")
public class ManagerModifyEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ManagerModifyEvent() {
        super();
        
    }



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destination = "managermodifyevent.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
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
	
		Event event = new Event();
		HttpSession successfullsession = request.getSession();
		HttpSession errorsession = request.getSession();
		String successmessage = "Event Modified Succesfully";
		
		Event eventmodel = new Event(eventid, eventname, eventdate,  starttime,  duration , location,  numberofattendees,  capacity,  eventcoordinator,  type, estattendees);
		EventDAO modifyevent = new EventDAO(ConnectionPro.getConnection());
		
		
		String durationErrormsg = event.validateDuration(starttime,duration);
		String eventdateErrormsg = event.validateDate(eventdate);
		String starttimeErrormsg = event.validateDateTime(eventdate,starttime);
		String capacityErrormsg = event.validateCapacity(capacity);
		String numberofattendeesErrormsg = event.validateNumberofattendees(estattendees,numberofattendees,capacity);
		String estattendeesErrormsg = event.validateEstattendees( numberofattendees,estattendees,capacity);
		String locationErrormsg = event.validateDecknumber(location);
		
		
		CheckErrorMsgs errormsg = new CheckErrorMsgs();
		
		String errors = errormsg.ModifyEventErrorMsg( eventdateErrormsg, capacityErrormsg, durationErrormsg,  locationErrormsg, numberofattendeesErrormsg, estattendeesErrormsg,starttimeErrormsg);
		
		if(!errors.equals(""))
		{
			errorsession.setAttribute("durationErrormsg",durationErrormsg );
			errorsession.setAttribute("eventdateErrormsg",eventdateErrormsg );
			errorsession.setAttribute("starttimeErrormsg",starttimeErrormsg );
			errorsession.setAttribute("capacityErrormsg",capacityErrormsg );
			errorsession.setAttribute("numberofattendeesErrormsg",numberofattendeesErrormsg );
			errorsession.setAttribute("estattendeesErrormsg",estattendeesErrormsg );
			errorsession.setAttribute("locationErrormsg",locationErrormsg );
			requestDispatcher.forward(request, response);
		}
		else
			{	
				modifyevent.ModifyEvent(eventmodel);
				response.sendRedirect("managersuccessmessage.jsp");
				successfullsession.setAttribute("successmessage", successmessage);	
				errorsession.removeAttribute("durationErrormsg");
				errorsession.removeAttribute("eventdateErrormsg");
				errorsession.removeAttribute("starttimeErrormsg");
				errorsession.removeAttribute("capacityErrormsg");
				errorsession.removeAttribute("numberofattendeesErrormsg");
				errorsession.removeAttribute("estattendeesErrormsg");
				errorsession.removeAttribute("locationErrormsg");
			}
		
		
	}		
	
}					
			
				
				

		
	


