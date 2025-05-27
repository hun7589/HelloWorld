package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1.Driver Manager
 * 2.Connection
 * 3.Statement
 * 4.실행
 * 5.ResultSet
 * 6.출력
 * 
 */
public class DatabaseExe {
	private static Connection conn;

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			conn.setAutoCommit(false);
			System.out.println("드라이버 연결.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 연결되지않았습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Statement 객체.
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "delete from product where p_code = 210";
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert,update,delete할 때는 executeUpdate()
			if (r > 0) {
				conn.commit();//commit
				System.out.println(r + "건 등록 되었습니다.");
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select*from product");//조회

			while (rs.next()) {
				System.out.println("상품코드 상품이름          가격");
				System.out.println("---------------------------");
				System.out.println(rs.getInt("p_code") + rs.getString("p_name") + rs.getInt("p_price"));

			}
			System.out.println("----------end of rows--------");
		} catch (SQLException e) {
			e.printStackTrace();

		}
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end of main.
}
