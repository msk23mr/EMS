package org.apache.struts.model;

public class Division implements Model {
	/**************************************************
	 * 変数の宣言
	 **************************************************/
	// 所属ID
	private String id;
	// 所属名
	private String name;
	// 所在地
	private String location;

	/**************************************************
	 * コンストラクタ
	 **************************************************/
	public Division() {
		this.id = null;
		this.name = null;
		this.location = null;
	}

	/**************************************************
	 * 各変数のゲッタとセッタ
	 **************************************************/

	/**
	 * 所属IDのゲッタ
	 *
	 * @return String型
	 */
	public String getId() {
		return id;
	}

	/**
	 * 所属IDのセッタ
	 *
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 所属名のゲッタ
	 *
	 * @return String型
	 */
	public String getName() {
		return name;
	}

	/**
	 * 所属名のセッタ
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 所在地のゲッタ
	 *
	 * @return String型
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 所在地のセッタ
	 *
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
