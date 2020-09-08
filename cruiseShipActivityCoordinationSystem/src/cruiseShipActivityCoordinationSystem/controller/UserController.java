package cruiseShipActivityCoordinationSystem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import cruiseShipActivityCoordinationSystem.data.UserDAO;
import cruiseShipActivityCoordinationSystem.model.User;
import cruiseShipActivityCoordinationSystem.model.UserErrorMsgs;



@WebServlet("/UserController")
public class UserController extends HttpServlet {
private static final long serialVersionUID = 1L;

private void getUserParam (HttpServletRequest request, User user) {
	user.setUser(request.getParameter("username"),request.getParameter("password"),request.getParameter("email"),request.getParameter("phone"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("roomnumber"),request.getParameter("decknumber"),request.getParameter("membershiptype"));  
}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(1);
		User user = new User();
		UserErrorMsgs UerrorMsgs = new UserErrorMsgs();
		session.removeAttribute("errorMsgs");
		
		if (action.equalsIgnoreCase("saveUser") ) {  
			getUserParam(request,user);
			user.validateUser(action,user,UerrorMsgs);
			session.setAttribute("user", user);
			if (!UerrorMsgs.getErrorMsg().equals("")) {// if error messages
				getUserParam(request,user);
				session.setAttribute("errorMsgs", UerrorMsgs);
				url="/signupForm.jsp";
			}
			else {// if no error messages
				UserDAO.insertUser(user);
				url="/index.jsp";
				session.removeAttribute("user");
			}
		}
		
		else 
			  if (action.equalsIgnoreCase("searchUser") ) {
				  
				 String username = request.getParameter("username");   
				 String password = request.getParameter("password");
				session.removeAttribute("errorMsgs");
				user.setUser(username,password,"","", "", "", "", "", "");
				user.validateUser(action, user, UerrorMsgs);
				
				if (UserDAO.searchUser(username, password)) {
					url = "/loginForm.jsp";}
				else {
					
					
						session.setAttribute("username", username);
		                if(((session!=null) && (session.getAttribute("username")!=null || session.getAttribute("username").equals(username)))) {
		                	url = "/userHomeScreen.jsp";
		                	
		                }
				}

			/*	ArrayList<User> userInDB = new ArrayList<User>();
				if (UerrorMsgs.getErrorMsg().equals("")) {
					if (!username.equals(""))
						userInDB=UserDAO.searchUser(username,password);
					else
						userInDB=UserDAO.searchUser(username,password);

					session.setAttribute("USERS", userInDB);
					session.removeAttribute("user");
					url="/userHomeScreen.jsp";
				}
				else {
					session.setAttribute("user", user);
					session.setAttribute("errorMsgs", UerrorMsgs);
					url="/loginForm.jsp";				*/
				
			}
			  else
				  if(action.equalsIgnoreCase("logoutUser")) {
					  if (session != null) {
				            session.removeAttribute("username");
				            request.getSession().invalidate();
				            url= "/loginForm.jsp";
				  }
				  }
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}