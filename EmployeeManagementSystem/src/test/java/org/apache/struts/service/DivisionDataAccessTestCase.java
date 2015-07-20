package org.apache.struts.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts.model.Division;
import org.junit.Test;

public class DivisionDataAccessTestCase {

	private DivisionDataAccess dda;
	private List<Division> divisions;

	@Test
	public void 所属データのリストを取得する() {
		dda = new DivisionDataAccess();
		divisions = dda.loadDivisionList();

		Iterator<Division> divisionIterator = divisions.iterator();
		Division division = null;

		if (divisionIterator.hasNext()) {
			division = divisionIterator.next();
			assertEquals("0101", division.getId());
			assertEquals("総務部", division.getName());
			assertEquals("北海道", division.getLocation());
		} else {
			fail("レコードがありません。データベースを確認してください。");
		}
	}

	@Test
	public void IDを指定して所属データのリストを取得する() {
		dda = new DivisionDataAccess();

		Map<String, String> where = new HashMap<String, String>();
		where.put("id", "0101");

		divisions = dda.searchDivisions(where);

		Iterator<Division> divisionIterator = divisions.iterator();
		Division division = null;

		if (divisionIterator.hasNext()) {
			division = divisionIterator.next();
			assertEquals("0101", division.getId());
			assertEquals("総務部", division.getName());
			assertEquals("北海道", division.getLocation());
		} else {
			fail("（ID指定）レコードがありません。データベースを確認してください。");
		}
	}

	@Test
	public void 所属名と所在地を指定して所属データのリストを取得() {
		dda = new DivisionDataAccess();

		Map<String, String> where = new HashMap<String, String>();
		where.put("name", "総務部");
		where.put("location", "東京都");

		divisions = dda.searchDivisions(where);

		Iterator<Division> divisionIterator = divisions.iterator();
		Division division = null;

		if (divisionIterator.hasNext()) {
			division = divisionIterator.next();
			assertEquals("0301", division.getId());
			assertEquals("総務部", division.getName());
			assertEquals("東京都", division.getLocation());
		} else {
			fail("（所属名と所在地指定）レコードがありません。データベースを確認してください。");
		}
	}

	@Test
	public void 所属データの追加と削除() {
		dda = new DivisionDataAccess();

		assertTrue(dda.addDivision("0103", "開発部", "01"));
		assertTrue(dda.deleteDivision("0103"));
	}

}
