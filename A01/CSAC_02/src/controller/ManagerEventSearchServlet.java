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


@WebServlet("/ManagerEventSearchServlet")
public class ManagerEventSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ManagerEventSearchServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eventdate = request.getParameter("eventdate");   
		String starttime = request.getParameter("starttime");
		Event event = new Event(eventdate,starttime);
		HttpSession session = request.getSession();


		ArrayList<Event> eventInDB = new ArrayList<Event>();
		if (!eventdate.equals("") && !starttime.equals(""))
		{
				eventInDB=EventDAO.getAllevents(eventdate, starttime);
				session.setAttribute("EVENTS", eventInDB);
				session.removeAttribute("event");
				response.sendRedirect("managereventsummary.jsp");
		}
		else {
			session.setAttribute("event", event);
			response.sendRedirect("managerhome.jsp");				
		}
		
		
		
	}

}
