package typing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ranking {

    public static void showTop10(Connection conn) {
        try {
            String sql = "SELECT u.username, r.speed, r.accuracy, r.played_at "
                       + "FROM results r "
                       + "JOIN users u ON r.user_id = u.id "
                       + "ORDER BY r.speed DESC "
                       + "FETCH FIRST 10 ROWS ONLY";

            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                System.out.println("\n===== 랭킹 (Top 10) =====");
                int rank = 1;
                while (rs.next()) {
                    String username = rs.getString("username");
                    double speed = rs.getDouble("speed");
                    double accuracy = rs.getDouble("accuracy");
                    String playedAt = rs.getTimestamp("played_at").toString();

                    System.out.printf("%d위) 사용자: %s | 속도: %.2f WPM | 정확도: %.2f%% | 날짜: %s%n",
                            rank, username, speed, accuracy, playedAt);
                    rank++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}