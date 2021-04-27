package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//JDBC : Java Database Connectivity
public class DBConnector {
	public static Connection getConnection() {
		Connection conn = null;
		// url, id, pw
		try {
			//만약 DB접속이 계속해서 실패하면 localhost대신 보인 서버 IP주소를 입력한다.
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "hr";
			String pw = "hr";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB 연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		} catch (Exception e) {
			System.out.println("getConnection() 알 수 없는 오류");
		}
		return conn;

	}
}
