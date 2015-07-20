package org.apache.struts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts.database.DatabaseAccess;
import org.apache.struts.model.Division;

public class DivisionDataAccess {
	private DatabaseAccess da;
	private ResultSet rs;

	public DivisionDataAccess() {
		da = new DatabaseAccess();
		rs = null;
	}

	public List<Division> loadDivisionList() {
		String division_select_all_sql = "SELECT "
				+ "D.division_id, D.division_name, P.prefecture_name as division_location "
				+ "FROM divisions as D " + "JOIN prefectures as P "
				+ "ON D.division_location = P.prefecture_id";

		List<Division> divisionList = new ArrayList<Division>();

		da.openConnection();

		rs = da.selectSQL(division_select_all_sql);

		try {
			while (rs.next()) {
				Division division = new Division();
				division.setId(rs.getString("division_id"));
				division.setName(rs.getString("division_name"));
				division.setLocation(rs.getString("division_location"));
				divisionList.add(division);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		da.closeConnection();

		return divisionList;
	}

	public List<Division> searchDivisions(Map<String, String> where) {
		String division_select_sql = "SELECT "
				+ "D.division_id, D.division_name, P.prefecture_name as division_location "
				+ "FROM divisions as D " + "JOIN prefectures as P "
				+ "ON D.division_location = P.prefecture_id";

		int where_size = where.size();

		while (!where.isEmpty()) {
			if (where_size == where.size()) {
				division_select_sql += " where ";
			} else {
				division_select_sql += " and ";
			}

			if (where.containsKey("id")) {
				division_select_sql += "D.division_id = \"" + where.get("id")
						+ "\"";
				where.remove("id");
				continue;
			}
			if (where.containsKey("name")) {
				division_select_sql += "D.division_name = \""
						+ where.get("name") + "\"";
				where.remove("name");
				continue;
			}
			if (where.containsKey("location")) {
				division_select_sql += "P.prefecture_name = \""
						+ where.get("location") + "\"";
				where.remove("location");
				continue;
			}
		}

		List<Division> divisionList = new ArrayList<Division>();

		da.openConnection();

		rs = da.selectSQL(division_select_sql);

		try {
			while (rs.next()) {
				Division division = new Division();
				division.setId(rs.getString("division_id"));
				division.setName(rs.getString("division_name"));
				division.setLocation(rs.getString("division_location"));
				divisionList.add(division);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		da.closeConnection();

		return divisionList;
	}

	public boolean addDivision(String id, String name, String location) {
		String division_insert_sql = "INSERT INTO divisions VALUES( \"" + id
				+ "\", \"" + name + "\", \"" + location + "\")";

		da.openConnection();

		if (da.updateSQL(division_insert_sql) == 1) {
			da.closeConnection();
			return true;
		} else {
			da.closeConnection();
			return false;
		}
	}

	public boolean deleteDivision(String id) {
		String division_delete_sql = "DELETE FROM divisions WHERE division_id = \""
				+ id + "\"";

		da.openConnection();

		if (da.updateSQL(division_delete_sql) == 1) {
			da.closeConnection();
			return true;
		} else {
			da.closeConnection();
			return false;
		}
	}
}
