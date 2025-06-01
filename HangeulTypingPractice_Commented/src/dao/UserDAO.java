
package src.dao;

import src.model.User;
import src.util.DBConnection;

import java.sql.*;

// 사용자 로그인 및 회원가입 처리 DAO 클래스
public class UserDAO {

    // 로그인 처리 메서드
    public static User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 로그인 성공 시 User 객체 반환
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        } catch (Exception e) {
            System.out.println("로그인 오류: " + e.getMessage());
        }
        return null;
    }

    // 회원가입 메서드
    public static boolean register(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("회원가입 오류: " + e.getMessage());
        }
        return false;
    }
}
