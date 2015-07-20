package org.apache.struts.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts.database.DatabaseAccess;
import org.apache.struts.model.Employee;

public class EmployeeDataAccess {
	private DatabaseAccess da;
	private ResultSet rs;

	public EmployeeDataAccess() {
		da = new DatabaseAccess();
		rs = null;
	}

	public List<Employee> loadEmployeeList() {
		String employee_select_all_sql = "SELECT " + "E.emp_id, "
				+ "E.emp_password, " + "E.emp_name, " + "E.emp_gender, "
				+ "E.emp_birth, " + "P.prefecture_name as emp_from, "
				+ "D.division_name as emp_division " + "FROM employees as E "
				+ "JOIN prefectures as P " + "ON E.emp_from = P.prefecture_id "
				+ "JOIN divisions as D " + "ON E.emp_division = D.division_id "
				+ "ORDER BY emp_id";

		List<Employee> employeeList = new ArrayList<Employee>();

		da.openConnection();

		rs = da.selectSQL(employee_select_all_sql);

		try {
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getString("emp_id"));
				employee.setPassword(rs.getString("emp_password"));
				employee.setName(rs.getString("emp_name"));
				employee.setGender(rs.getBoolean("emp_gender"));
				employee.setBirth(rs.getDate("emp_birth"));
				employee.setFrom(rs.getString("emp_from"));
				employee.setDivision(rs.getString("emp_division"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		da.closeConnection();

		return employeeList;
	}

	public List<Employee> searchEmployees(Map<String, Object> where) {
		return null;
	}

	public boolean addEmployee(String id, String password, String name,
			boolean gender, Date birth, String from, String division) {
		return false;
	}

	public boolean deleteEmployee(String id) {
		return false;
	}

	public boolean updateEmployee(String id, Map<String, Object> set) {
		return false;
	}
}
