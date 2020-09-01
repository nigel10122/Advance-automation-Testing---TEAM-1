package com.java.controller;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.java.data.*;
import com.java.model.*;

@WebServlet("/userController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	private void getUsersParam (HttpServletRequest request, User user) {
		user.setUser(request.getParameter("userid"),request.getParameter("username"),request.getParameter("lastname"),request.getParameter("firstname"),request.getParameter("password")
		,request.getParameter("email"),request.getParameter("number"),request.getParameter("roomnumber"),request.getParameter("decknumber"),request.getParameter("membership"));  
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
//		List companies
		if (action.equalsIgnoreCase("listuser")) {
			ArrayList<User> userInDB = new ArrayList<User>();
			userInDB=UserDAO.listUsers();
			session.setAttribute("USERS", userInDB);				
			getServletContext().getRequestDispatcher("/listuser.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		User user = new User();
		UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
		int selecteduserIndex;
		session.removeAttribute("errorMsgs");
		
	

		if (action.equalsIgnoreCase("saveUser") ) {  
			getUsersParam(request,user);
			user.validateUser(action,user,CerrorMsgs);
			session.setAttribute("user", user);
			if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
				getUsersParam(request,user);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/formuser.jsp";
			}
			else {// if no error messages
				UserDAO.insertUser(user);
				url="/userSuccess.jsp";
			}
		}
		else
		  if (action.equalsIgnoreCase("UserLogin") ) {  
				String username = request.getParameter("username");  
				String password = request.getParameter("password"); 
				session.removeAttribute("errorMsgs");
				user.setUser(username,password,"","","","","","","","");
				user.validateUser(action,user, CerrorMsgs);

				ArrayList<User> userInDB = new ArrayList<User>();
				if (CerrorMsgs.getErrorMsg().equals("")) {
					if (!username.equals("") && !password.equals(""))
						userInDB=UserDAO.UserLogin(username,password);

					session.setAttribute("USERS", userInDB);
					session.removeAttribute("user");
					url="/userSearchResults.jsp";
				}
				else {
					session.setAttribute("user", user);
					session.setAttribute("errorMsgs", CerrorMsgs);
					url="/searchuser.jsp";				
				}
			}
		
		 else 
		  if (action.equalsIgnoreCase("searchUser") ) {  
			String lastname = request.getParameter("lastname");  
			session.removeAttribute("errorMsgs");
			user.setUser(lastname,"","","","","","","","","");
			user.validateUser(action,user, CerrorMsgs);

			ArrayList<User> userInDB = new ArrayList<User>();
			if (CerrorMsgs.getErrorMsg().equals("")) {
				if (!lastname.equals(""))
					userInDB=UserDAO.searchUser(lastname);

				session.setAttribute("USERS", userInDB);
				session.removeAttribute("user");
				url="/userSearchResults.jsp";
			}
			else {
				session.setAttribute("user", user);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/searchuser.jsp";				
			}
		}
		else { //action=listSpecificuser
			ArrayList<User> userInDB = new ArrayList<User>();
			User selecteduser = new User();
			if (request.getParameter("radiouser")!=null) {
				selecteduserIndex = Integer.parseInt(request.getParameter("radiouser")) - 1;
				userInDB=UserDAO.listUsers(); 
				selecteduser.setUser(userInDB.get(selecteduserIndex).getUserId(),	userInDB.get(selecteduserIndex).getUsername(), userInDB.get(selecteduserIndex).getLastname(), 
						userInDB.get(selecteduserIndex).getFirstname(), userInDB.get(selecteduserIndex).getPassword(),
						userInDB.get(selecteduserIndex).getEmail(),userInDB.get(selecteduserIndex).getNumber(),userInDB.get(selecteduserIndex).getRoomnumber(),
						userInDB.get(selecteduserIndex).getDecknumber(),userInDB.get(selecteduserIndex).getMembership());
				session.setAttribute("USERS", selecteduser);
				url="/ListSpecificuser.jsp";					
			}
			else { // determine if Submit button was clicked without selecting a user
				if (request.getParameter("ListSelecteduserButton")!=null) {
					String errorMsgs =  "Please select a user";
					session.setAttribute("errorMsgs",errorMsgs);
					url="/listuser.jsp";					
				}
				else { //view button was used instead of radio button
					userInDB=UserDAO.searchUser(request.getParameter("username"));
					selecteduser.setUser(userInDB.get(0).getUserId(),	userInDB.get(0).getUsername(), userInDB.get(0).getLastname(), 
							userInDB.get(0).getFirstname(), userInDB.get(0).getPassword(),
							userInDB.get(0).getEmail(),userInDB.get(0).getNumber(),userInDB.get(0).getRoomnumber(),
							userInDB.get(0).getDecknumber(),userInDB.get(0).getMembership());
					session.setAttribute("COMPANIES", selecteduser);
					url="/ListSpecificuser.jsp";					
				}
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}
