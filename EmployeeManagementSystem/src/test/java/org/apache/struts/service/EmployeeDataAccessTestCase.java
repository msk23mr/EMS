package org.apache.struts.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.model.Employee;
import org.junit.Test;

public class EmployeeDataAccessTestCase {

	private EmployeeDataAccess eda;
	private List<Employee> employees;

	@Test
	public void 社員データのリストを取得() {
		eda = new EmployeeDataAccess();
		employees = eda.loadEmployeeList();

		Iterator<Employee> employeeIterator = employees.iterator();
		Employee employee = null;

		if (employeeIterator.hasNext()) {
			employee = employeeIterator.next();
			assertEquals("0001", employee.getId());
			assertEquals("1111aaaa", employee.getPassword());
			assertEquals("佐藤拓哉", employee.getName());
			assertFalse(employee.isGender());
			assertEquals(Date.valueOf("1990-08-05"), employee.getBirth());
			assertEquals("北海道", employee.getFrom());
			assertEquals("営業部", employee.getDivision());
		} else {
			fail("レコードがありません。データベースを確認してください。");
		}

	}

	@Test
	public void IDを指定して社員データを取得() {
		fail("まだ実装されていません");
	}

	@Test
	public void IDとパスワードを指定して社員データを取得() {
		fail("まだ実装されていません");
	}

	@Test
	public void 年齢を指定して社員データを取得() {
		fail("まだ実装されていません");
	}

	@Test
	public void 性別を指定して社員データを取得() {
		fail("まだ実装されていません");
	}

	@Test
	public void 所属を指定して社員データを取得() {
		fail("まだ実装されていません");
	}

	@Test
	public void 出身地を指定して社員データを取得() {
		fail("まだ実装されていません");
	}

	@Test
	public void 社員データの追加と削除() {
		fail("まだ実装されていません");
	}

	@Test
	public void 社員データの変更() {
		fail("まだ実装されていません");
	}
}
