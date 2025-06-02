package typing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class HistoryViewer {

    public static void printMyHistory(Connection conn, int userId) {
        String sql = "SELECT r.speed, r.accuracy, r.played_at, t.title, t.level, t.language "
                   + "FROM results r "
                   + "JOIN texts t ON r.text_id = t.id "
                   + "WHERE r.user_id = ? "
                   + "ORDER BY r.played_at DESC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n===== 내 기록 보기 =====");
                int count = 0;
                while (rs.next()) {
                    count++;
                    double speed = rs.getDouble("speed");
                    double accuracy = rs.getDouble("accuracy");
                    Timestamp playedAt = rs.getTimestamp("played_at");
                    String title = rs.getString("title");
                    String level = rs.getString("level");
                    String language = rs.getString("language");

                    System.out.printf("%d) 날짜: %s | 제목: %s | 난이도: %s | 언어: %s | 속도: %.2f WPM | 정확도: %.2f%%%n",
                            count, playedAt.toString(), title, level, language, speed, accuracy);
                }
                if (count == 0) {
                    System.out.println("기록이 없습니다.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}