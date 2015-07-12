package org.apache.struts.service;

import java.util.List;

import org.apache.struts.model.Model;

public interface DataAccessService {

	/**
	 * モデル型でデータを取得するメソッド
	 *
	 * @param id
	 *            取得するデータのID
	 * @return Model型 指定したIDを持つデータのモデルオブジェクト
	 */
	Model loadData(String id);

	/**
	 * モデル型のリストを取得するメソッド（条件指定なし）
	 *
	 * @return List<Model> モデルオブジェクトのリスト
	 */
	List<Model> loadDataList();

	/**
	 * モデル型のリストを取得するメソッド（条件指定あり）
	 *
	 * @param sql
	 *            実行するSQL文を指定
	 *
	 * @return List<Model> モデルオブジェクトのリスト
	 */
	List<Model> loadDataList(String sql);

}
