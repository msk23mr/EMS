package org.apache.struts.action;

import org.apache.struts.model.Employee;

public class LoginAction extends AbstractAction {

	private Employee employeeBean;

	@Override
	public String execute() throws Exception {

		if (checkLogin()) {

		}

		return SUCCESS;
	}

	public Employee getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}
