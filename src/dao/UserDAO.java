package src.dao;

import src.model.User;
import src.util.DBConnection;

import java.sql.*;

public class UserDAO {
    public static boolean register(String uname, String pw) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, uname);
            pstmt.setString(2, pw);
            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("회원가입 오류: " + e.getMessage());
            return false;
        }
    }

    public static User login(String uname, String pw) {
        String sql = "SELECT id, username FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, uname);
            pstmt.setString(2, pw);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"));
            }

        } catch (SQLException e) {
            System.out.println("로그인 오류: " + e.getMessage());
        }

        return null;
    }
}
