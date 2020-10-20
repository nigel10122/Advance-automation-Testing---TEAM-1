package company_management.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import company_management.data.CompanyDAO;
import company_management.data.EmployeeDAO;
import company_management.model.*;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		//insert employee
		if (action.equals("insertEmployee")) {
			if (request.getParameter("insertEmpbutton")!=null) {  //insert employee button pressed
				Employee employee = new Employee();
				Company company = (Company) session.getAttribute("company"); 
				employee.setEmployee(request.getParameter("idemployee"), request.getParameter("name"), request.getParameter("surname"), request.getParameter("badge"));
				EmployeeErrorMsgs EerrorMsgs = new EmployeeErrorMsgs();
				employee.validateEmployee(employee, EerrorMsgs);
				employee.setFk_company(company.getIdcompany());
				session.setAttribute("employee",employee);
				session.setAttribute("errorMsgs",EerrorMsgs);
				if (EerrorMsgs.getErrorMsg().equals("")) {
					EmployeeDAO.insertEmployee(employee);
					session.removeAttribute("employee");					
				}
				url = "/formEmployee.jsp"; 
			}
			else { // done button pressed
				session.removeAttribute("company");
				session.removeAttribute("employee");
				session.removeAttribute("COMPANIES");
				session.removeAttribute("errorMsgs");
				url="/index.jsp";
			}
		}

		else  { // develop dynamic dropdown list for searchEmployee jsp
			if (action.equals("searchEmployee")) {
				ArrayList<Company> company = new ArrayList<Company>();
				company = CompanyDAO.listCompanies();
				session.setAttribute("company",company);
				url="/searchEmployee.jsp"; }
			else {// action=selectEmployee - specific company chosen
				ArrayList<Employee> employeesInDB = new ArrayList<Employee>();
				employeesInDB=EmployeeDAO.listEmployees(request.getParameter("cname"));
				session.setAttribute("employees", employeesInDB);
				session.removeAttribute("company");
				session.removeAttribute("errorMsgs");
				session.removeAttribute("COMPANIES");
				url="/listEmployee.jsp";
				}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}