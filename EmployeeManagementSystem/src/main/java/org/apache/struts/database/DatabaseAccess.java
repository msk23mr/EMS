package org.apache.struts.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import javax.sql.DataSource;

public class DatabaseAccess {
	/*********************************************
	 * 変数の宣言
	 *********************************************/

	// データソース
	private DataSource ds;
	// コネクション
	private Connection conn;
	// ステートメント
	private Statement stat;
	// 結果セット
	private ResultSet rs;

	/*********************************************
	 * コンストラクタ
	 *********************************************/
	public DatabaseAccess() {
		// データソース取得
		ds = DataSourceFactory.getDataSource();
		// コネクション初期化
		conn = null;
		// ステートメント初期化
		stat = null;
		// 結果セット初期化
		rs = null;
	}

	/*********************************************
	 * メソッド
	 *********************************************/

	/**
	 * コネクション確立メソッド
	 *
	 * @return boolean コネクション確立の成否
	 */
	public boolean openConnection() {
		try {
			// データソースからコネクション取得
			conn = ds.getConnection();
		} catch (SQLException e) {
			System.out.println("コネクションの確立に失敗");
			return false;
		}

		return true;
	}

	/**
	 * コネクション切断メソッド
	 *
	 * @return boolean コネクション切断の成否
	 */
	public boolean closeConnection() {
		// 結果セットが生成されていた場合
		if (!Objects.equals(rs, null)) {
			try {
				// 結果セットをクローズ
				rs.close();
			} catch (SQLException e) {
				System.out.println("結果セットのクローズに失敗");
				return false;
			}
		}
		// ステートメントが生成されていた場合
		if (!Objects.equals(stat, null)) {
			try {
				// ステートメントをクローズ
				stat.close();
			} catch (SQLException e) {
				System.out.println("ステートメントのクローズに失敗");
				return false;
			}
		}
		// コネクションが確立されていた場合
		if (!Objects.equals(conn, null)) {
			try {
				// コネクションを切断
				conn.close();
			} catch (SQLException e) {
				System.out.println("コネクションの切断に失敗");
				return false;
			}
		} else {
			// コネクションが確立されていない場合は、FALSEを返す
			return false;
		}

		return true;
	}

	/**
	 * SELECT文の実行メソッド
	 *
	 * @param sql
	 *            実行するSELECT文
	 * @return ResultSet SELECT文の実行結果
	 */
	public ResultSet selectSQL(String sql) {
		try {
			// コネクションからステートメントを生成
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("ステートメントの生成に失敗");
		}

		try {
			// 引数で渡されたSELECT文を実行
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("SQLの実行に失敗");
			System.out.println("SQL : " + sql);
		}

		// 実行結果を返す
		return rs;
	}

	/**
	 * INSERT文・UPDATE文・DELETE文の実行メソッド
	 *
	 * @param sql
	 *            実行するSQL文
	 * @return int SQLの実行対象になったレコード数
	 */
	public int updateSQL(String sql) {
		try {
			// コネクションからステートメントを生成
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("ステートメントの生成に失敗");
		}

		try {
			// 引数で渡されたSQL文を実行
			return stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQLの実行に失敗");
			System.out.println("SQL : " + sql);
			return -1;
		}
	}
}
