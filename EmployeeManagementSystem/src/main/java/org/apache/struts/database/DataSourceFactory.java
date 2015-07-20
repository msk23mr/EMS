package org.apache.struts.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceFactory {

	// データベース定義ファイルのパス
	private static String props_file_path = System.getProperty("user.dir")
			+ "/src/main/resources/org/apache/struts/database/db.properties";

	/**
	 * データソースの取得メソッド
	 *
	 * データベース定義ファイルで指定されたRDBMSタイプ毎に処理を分岐
	 *
	 * 2015/07/20時点では、MySQLのみ
	 *
	 * @return DataSource
	 */
	public static DataSource getDataSource() {
		// プロパティオブジェクト
		Properties props = new Properties();
		// データベース定義ファイルを読み込むオブジェクト
		FileInputStream fis = null;

		try {
			// データベース定義ファイルを読み込む
			fis = new FileInputStream(props_file_path);
			// プロパティをロード
			props.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("データベース定義ファイルの読み込みに失敗");
		} catch (IOException e) {
			System.out.println("プロパティのロードに失敗");
		}

		// RDBMSタイプにMySQLが指定されている場合
		if (props.getProperty("RDBMS_TYPE").equals("mysql")) {
			// MySQLのデータソースを取得
			return getMysqlDataSource(props);
		} else {
			// 不明なRDBMSタイプが指定された場合、NULLを返す
			return null;
		}
	}

	/**
	 * MySQLデータソースを取得
	 *
	 * MySQL用のデータソースを生成します。
	 *
	 * データソースの設定は、データベース定義プロパティから取得しています。
	 *
	 * @param props
	 *            Properties データベース定義プロパティ
	 * @return DataSource
	 */
	private static MysqlDataSource getMysqlDataSource(Properties props) {
		// MySQLのデータソースオブジェクトを生成
		MysqlDataSource mysqlDS = new MysqlDataSource();

		// MySQLデータソースの設定

		// URL
		mysqlDS.setUrl(props.getProperty("MY_SQL_URL"));
		// ユーザ名
		mysqlDS.setUser(props.getProperty("MY_SQL_USER"));
		// パスワード
		mysqlDS.setPassword(props.getProperty("MY_SQL_PASSWORD"));

		return mysqlDS;
	}
}
