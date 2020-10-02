package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ReservationDAO;

import model.Reservation;

import util.ConnectionPro;


@WebServlet("/PassengerReserveEvents")
public class PassengerReserveEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PassengerReserveEvents() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
		
		HttpSession successfullsession = request.getSession();
		String reservationsuccessmsg = "Reservation Succesfull";
		
		Reservation reservationModel = new Reservation( eventname, eventdate,  starttime,  duration , location,  numberofattendees,  capacity,  eventcoordinator,  type,estattendees,firstname,lastname,number,email);
		
	try
		{
			ReservationDAO reserveevent = new ReservationDAO(ConnectionPro.getConnection());
			if(reserveevent.ReserveEvent(reservationModel))
			{
				response.sendRedirect("welcome.jsp");
				successfullsession.setAttribute("reservationsuccessmsg", reservationsuccessmsg);	
			}
			else
				response.sendRedirect("passengerreserveevent.jsp");
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	
	
	
	}		
				
}					
				

		
	


