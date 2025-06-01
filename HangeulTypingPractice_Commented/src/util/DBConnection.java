
package src.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// MySQL 데이터베이스 연결 유틸 클래스
public class DBConnection {

    // DB 연결 정보 (사용자 환경에 맞게 수정 필요)
    private static final String URL = "jdbc:mysql://localhost:3306/typing_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "your_uname";
    private static final String PASSWORD = "your_pw";

    // DB 연결을 반환하는 정적 메서드
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
