package org.apache.struts.database;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts.database.DatabaseAccess;
import org.junit.Test;

public class DatabaseAccessTestCase {

	private DatabaseAccess da = new DatabaseAccess();

	@Test
	public void データベースコネクションを確立する() {
		assertTrue(da.openConnection());
		da.closeConnection();
	}

	@Test
	public void データベースコネクションを切断する() {
		assertFalse(da.closeConnection());
		da.openConnection();
		assertTrue(da.closeConnection());
	}

	@Test
	public void SELECT文の実行() {
		String select_sql = "select * from divisions where division_id = \"0101\"";
		ResultSet rs = null;

		da.openConnection();
		rs = da.selectSQL(select_sql);

		try {
			while (rs.next()) {
				assertEquals("0101", rs.getString("division_id"));
				assertEquals("総務部", rs.getString("division_name"));
				assertEquals("01", rs.getString("division_location"));
			}
		} catch (SQLException e) {
			fail("結果セットエラー");
		}

		da.closeConnection();
	}

	@Test
	public void INSERT文とUPDATE文とDELETE文の実行() {
		String insert_sql = "insert into divisions values (\"0103\", \"開発部\", \"03\")";
		String update_sql = "update divisions set division_id = \"0403\", division_name = \"事業部\" where division_id = \"0103\"";
		String delete_sql = "delete from divisions where division_id = \"0403\"";
		da.openConnection();
		assertEquals("insert", 1, da.updateSQL(insert_sql));
		assertEquals("update", 1, da.updateSQL(update_sql));
		assertEquals("delete", 1, da.updateSQL(delete_sql));
		da.closeConnection();
	}
}
