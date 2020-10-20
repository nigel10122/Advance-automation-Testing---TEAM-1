package company_management.model;

public class EmployeeErrorMsgs {

	private String errorMsg;
	private String employeeIDerror;
	private String firstNameError;
	private String lastNameError;
	private String companyBadgeError;
	
	public EmployeeErrorMsgs() {
		this.errorMsg = "";
// Comment out the following to get PIT coverage even though it is not per Oracle
/*		this.employeeIDerror = "";
		this.firstNameError = "";
		this.lastNameError = "";
		this.companyBadgeError = "";
*/	}

	public String getErrorMsg() {
		return errorMsg;
	}
//
//  NOTE: 	The following code is not representative of how this would be coded in an industrial application.
//			We are using this code to maximize the ability of Pit to mutate the code to determine how
//			good the developed test cases are. This course is using this Java backend code as an application
//			of the principles learned in CSE 5321 only.
//	
	public void setErrorMsg() {
		if (!employeeIDerror.equals("") || !firstNameError.equals("") || !lastNameError.equals("") || !companyBadgeError.equals(""))
			errorMsg = "Please correct the following errors";
	}
	public String getEmployeeIDerror() {
		return employeeIDerror;
	}
	public void setEmployeeIDerror(String employeeIDerror) {
		this.employeeIDerror = employeeIDerror;
	}
	public String getFirstNameError() {
		return firstNameError;
	}

	public void setFirstNameError(String firstNameError) {
		this.firstNameError = firstNameError;
	}

	public String getLastNameError() {
		return lastNameError;
	}

	public void setLastNameError(String lastNameError) {
		this.lastNameError = lastNameError;
	}

	public String getCompanyBadgeError() {
		return companyBadgeError;
	}

	public void setCompanyBadgeError(String companyBadgeError) {
		this.companyBadgeError = companyBadgeError;
	}
}