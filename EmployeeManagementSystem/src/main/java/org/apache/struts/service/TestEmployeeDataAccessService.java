package org.apache.struts.service;

import java.sql.Date;
import java.util.List;

import org.apache.struts.model.Employee;
import org.apache.struts.model.Model;

public class TestEmployeeDataAccessService implements DataAccessService {

	private Employee employeeBean;

	@Override
	public Model loadData(String id) {
		// 社員IDを基にDBからデータを取得
		// 取得したデータから社員モデルオブジェクトを生成
		employeeBean = new Employee();
		// ここでは、ダミーデータから社員モデルオブジェクトを生成して、
		// 結果として返します。
		employeeBean.setId("1234");
		employeeBean.setPassword("1234");
		employeeBean.setName("masaki mori");
		employeeBean.setGender(false);
		employeeBean.setBirth(Date.valueOf("1986-06-03"));
		employeeBean.setFrom("北海道");
		employeeBean.setDivision("システム開発部");

		return employeeBean;
	}

	@Override
	public List<Model> loadDataList() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<Model> loadDataList(String sql) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
