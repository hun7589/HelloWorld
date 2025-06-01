package src.dao;

import src.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultDAO {

    public static void saveResult(int userId, int textId, double speed, double accuracy) {
        String sql = "INSERT INTO results (user_id, text_id, speed, accuracy) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, textId);
            pstmt.setDouble(3, speed);
            pstmt.setDouble(4, accuracy);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("결과 저장 실패: " + e.getMessage());
        }
    }
}
