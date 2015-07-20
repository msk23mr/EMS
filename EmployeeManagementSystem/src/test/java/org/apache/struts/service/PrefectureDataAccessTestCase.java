package org.apache.struts.service;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.apache.struts.model.Prefecture;
import org.junit.Test;

public class PrefectureDataAccessTestCase {

	private PrefectureDataAccess pda = null;
	private List<Prefecture> prefectures = null;

	@Test
	public void 都道府県データのリストを取得する() {
		pda = new PrefectureDataAccess();
		prefectures = pda.loadPrefectureList();

		Iterator<Prefecture> prefecture_iterator = prefectures.iterator();
		Prefecture prefecture = null;

		if (prefecture_iterator.hasNext()) {
			prefecture = prefecture_iterator.next();
			assertEquals("01", prefecture.getId());
			assertEquals("北海道", prefecture.getName());
		} else {
			fail("レコードがありません。データベースを確認してください。");
		}
	}

}
