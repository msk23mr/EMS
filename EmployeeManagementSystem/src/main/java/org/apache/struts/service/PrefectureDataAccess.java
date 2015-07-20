package org.apache.struts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.database.DatabaseAccess;
import org.apache.struts.model.Prefecture;

public class PrefectureDataAccess {
	private DatabaseAccess da;
	private ResultSet rs;

	public PrefectureDataAccess() {
		da = new DatabaseAccess();
		rs = null;
	}

	public List<Prefecture> loadPrefectureList() {
		String prefecture_select_all_sql = "SELECT "
				+ "P.prefecture_id, P.prefecture_name "
				+ "FROM prefectures as P";

		List<Prefecture> prefectureList = new ArrayList<Prefecture>();

		da.openConnection();

		rs = da.selectSQL(prefecture_select_all_sql);

		try {
			while (rs.next()) {
				Prefecture prefecture = new Prefecture();
				prefecture.setId(rs.getString("prefecture_id"));
				prefecture.setName(rs.getString("prefecture_name"));
				prefectureList.add(prefecture);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		da.closeConnection();

		return prefectureList;
	}
}
