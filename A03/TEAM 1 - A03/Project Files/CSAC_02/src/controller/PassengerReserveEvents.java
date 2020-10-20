package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ReservationDAO;
import model.Event;
import model.Reservation;

import util.ConnectionPro;


@WebServlet("/PassengerReserveEvents")
public class PassengerReserveEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PassengerReserveEvents() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//session.removeAttribute("errorMsgs");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "passengerreserveevent.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		HttpSession session = request.getSession();
		

		session.removeAttribute("errorMsgs");

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
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		HttpSession errorsession = request.getSession();
		
		HttpSession successfullsession = request.getSession();
		String successmessage = "Reservation Succesfull";
		Reservation reservation = new Reservation();
		
		Reservation reservationModel = new Reservation( eventname, eventdate,  starttime,  duration , location,  numberofattendees,  capacity,  eventcoordinator,  type,estattendees,firstname,lastname,number,email);
		
		String reservationerrMsg = reservation.getCountShowTypeModel(type, eventdate, firstname, lastname);
		
		Event event = new Event();
		String eventdateErrormsg = event.validateDate(eventdate);
		String starttimeErrormsg = event.validateDateTime(eventdate, starttime);
		
		if(!eventdateErrormsg.equals("") || !starttimeErrormsg.equals(""))
		{
			errorsession.setAttribute("eventdateErrormsg", eventdateErrormsg);
			errorsession.setAttribute("starttimeErrormsg", starttimeErrormsg);
			requestDispatcher.forward(request, response);
			
		}
	else
		if(!reservationerrMsg.equals("")) 
		{
			if(type.equalsIgnoreCase("Show")) {
				response.sendRedirect("ExceedEventShow.jsp");
				//errorsession.setAttribute("reservationerrMsg",reservationerrMsg);

			}
			else {
			response.sendRedirect("ExceedAthleticEvent.jsp");
			//errorsession.setAttribute("reservationerrMsg",reservationerrMsg);

			}
		}		
else {
	try
		{
			ReservationDAO reserveevent = new ReservationDAO(ConnectionPro.getConnection());
			if(reserveevent.ReserveEvent(reservationModel))
			{
				response.sendRedirect("passengersuccessmessage.jsp");
				successfullsession.setAttribute("successmessage", successmessage);	
			}
			else
				response.sendRedirect("welcome.jsp");
		}catch(Exception e) {
			
			e.printStackTrace();
		}
}
	
	
	}		}
				
				
				

		
	

