package org.apache.struts.model;

public class Prefecture implements Model {
	/***************************************************
	 * 変数の宣言
	 ***************************************************/
	// 都道府県ID
	private String id;
	// 都道府県名
	private String name;

	/***************************************************
	 * コンストラクタ
	 ***************************************************/
	public Prefecture() {
		this.id = null;
		this.name = null;
	}

	/***************************************************
	 * 各変数のゲッタとセッタ
	 ***************************************************/

	/**
	 * 都道府県IDのゲッタ
	 *
	 * @return String型
	 */
	public String getId() {
		return id;
	}

	/**
	 * 都道府県IDのセッタ
	 *
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 都道府県名のゲッタ
	 *
	 * @return String型
	 */
	public String getName() {
		return name;
	}

	/**
	 * 都道府県名のセッタ
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
