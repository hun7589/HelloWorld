
package src.dao;

import java.sql.*;

// 타자 연습 결과를 DB에 저장하거나 랭킹을 조회하는 DAO 클래스
public class ResultDAO {
    // 결과 저장 SQL
    private static final String INSERT_SQL = 
        "INSERT INTO results (user_id, text_id, speed, accuracy) VALUES (?, ?, ?, ?)";

    // 랭킹 조회 SQL (속도 기준 상위 10명)
    private static final String RANKING_SQL = 
        "SELECT u.username, r.speed, r.accuracy, r.played_at FROM results r " +
        "JOIN users u ON r.user_id = u.id ORDER BY r.speed DESC LIMIT 10";

    // 결과 저장 메서드
    public static void saveResult(Connection conn, int userId, int textId, double speed, double accuracy) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, textId);
            pstmt.setDouble(3, speed);
            pstmt.setDouble(4, accuracy);
            pstmt.executeUpdate();
        }
    }

    // 랭킹 출력 메서드
    public static void showRanking(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(RANKING_SQL)) {

            System.out.println("=== 📊 Top 10 랭킹 ===");
            int rank = 1;
            while (rs.next()) {
                String username = rs.getString("username");
                double speed = rs.getDouble("speed");
                double accuracy = rs.getDouble("accuracy");
                Timestamp playedAt = rs.getTimestamp("played_at");

                System.out.printf("%d위: %s | 속도: %.2f타/분 | 정확도: %.2f%% | 날짜: %s%n",
                        rank++, username, speed, accuracy, playedAt.toString());
            }
        }
    }
}
