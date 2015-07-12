package org.apache.struts.action;

import org.apache.struts.model.Employee;

public class LogoutAction extends AbstractAction {
	private Employee employeeBean;

	@Override
	public String execute() throws Exception {
		removeAuthId();
		return SUCCESS;
	}

	public Employee getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}
