package org.apache.struts.database;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.struts.database.DataSourceFactory;
import org.junit.After;
import org.junit.Test;

public class DataSourceFactoryTestCase {

	private DataSource ds = null;

	@After
	public void setUp() throws Exception {
		ds = null;
	}

	@Test
	public void データソース取得する() {
		ds = DataSourceFactory.getDataSource();

		assertNotNull(ds);
	}

	@Test
	public void データベースにアクセスする() {

		ds = DataSourceFactory.getDataSource();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			fail("コネクションの確立に失敗");
		}

		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			fail("ステートメントの生成に失敗");
		}

		try {
			rs = stat
					.executeQuery("select * from divisions where division_id = \"0101\"");
			while (rs.next()) {
				assertEquals("0101", rs.getString("division_id"));
				assertEquals("総務部", rs.getString("division_name"));
				assertEquals("01", rs.getString("division_location"));
			}
		} catch (SQLException e) {
			fail("SQLの実行に失敗");
		}

	}
}
