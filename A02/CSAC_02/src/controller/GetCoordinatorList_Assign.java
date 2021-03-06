package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.EventDAO;
import data.UserDAO;
import model.Event;
import model.User;


@WebServlet("/GetCoordinatorList_Assign")
public class GetCoordinatorList_Assign extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetCoordinatorList_Assign() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				HttpSession session = request.getSession();
				
				ArrayList<User> userListInDB = new ArrayList<User>();
				userListInDB=UserDAO.getCoordinatornames();
				session.setAttribute("USERS", userListInDB);
				session.removeAttribute("user");
				response.sendRedirect("managerassigneventcoordinator.jsp");
		}
	
		
		
	}


