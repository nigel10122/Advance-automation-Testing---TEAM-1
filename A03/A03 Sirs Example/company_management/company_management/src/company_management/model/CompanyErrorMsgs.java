package company_management.model;

public class CompanyErrorMsgs {

	private String errorMsg;
	private String companyIDerror;
	private String companyNameError;
	private String phoneError;
	private String emailError;
	
	public CompanyErrorMsgs() {
		this.errorMsg = "";
		this.companyIDerror = "";
		this.companyNameError = "";
		this.phoneError = "";
		this.emailError = "";
	}

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
		if (!companyIDerror.equals("") || !companyNameError.equals("") || !phoneError.equals("") || !emailError.equals(""))
			this.errorMsg = "Please correct the following errors";
	}
	public String getCompanyIDerror() {
		return companyIDerror;
	}
	public void setCompanyIDerror(String companyIDerror) {
		this.companyIDerror = companyIDerror;
	}
	public String getCompanyNameError() {
		return companyNameError;
	}
	public void setCompanyNameError(String companyNameError) {
		this.companyNameError = companyNameError;
	}
	public String getPhoneError() {
		return phoneError;
	}
	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
}