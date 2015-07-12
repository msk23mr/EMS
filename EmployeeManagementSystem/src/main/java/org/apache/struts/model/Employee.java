package org.apache.struts.model;

import java.sql.Date;

public class Employee implements Model {
	/****************************************************
	 * 変数の宣言
	 ****************************************************/
	// 社員ID
	private String id;
	// パスワード
	private String password;
	// 社員名
	private String name;
	// 性別（false : 男性 true : 女性）
	private boolean gender;
	// 生年月日（yyyy-mm-dd）
	private Date birth;
	// 出身地（都道府県）
	private String from;
	// 所属名
	private String division;

	/*****************************************************
	 * コンストラクタ
	 *****************************************************/
	public Employee() {
		super();
		this.id = null;
		this.password = null;
		this.name = null;
		this.gender = false;
		this.birth = new Date(0);
		this.from = null;
		this.division = null;
	}

	/****************************************************
	 * 各変数のセッタとゲッタ
	 ****************************************************/

	/**
	 * 社員IDのゲッタ
	 *
	 * @return String型
	 */
	public String getId() {
		return id;
	}

	/**
	 * 社員IDのセッタ
	 *
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * パスワードのゲッタ
	 *
	 * @return String型
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードのセッタ
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 社員名のゲッタ
	 *
	 * @return String型
	 */
	public String getName() {
		return name;
	}

	/**
	 * 社員名のセッタ
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 性別のゲッタ
	 *
	 * @return Boolean型（false : 男性 true : 女性）
	 */
	public boolean isGender() {
		return gender;
	}

	/**
	 * 性別のセッタ
	 *
	 * @param gender
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}

	/**
	 * 生年月日のゲッタ
	 *
	 * @return java.sql.Date型
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * 生年月日のセッタ
	 *
	 * @param birth
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * 出身地のゲッタ
	 *
	 * @return String型
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * 出身地のセッタ
	 *
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * 所属名のゲッタ
	 *
	 * @return String型
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * 所属名のセッタ
	 *
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
}
