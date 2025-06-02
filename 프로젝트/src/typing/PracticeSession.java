package typing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PracticeSession {

    public static void start(Connection conn, int userId, Scanner sc) {
        try {
            System.out.println("\n===== 연습 시작 =====");
            System.out.print("난이도 선택 (1: 초급, 2: 중급, 3: 고급)> ");
            String lvlChoice = sc.nextLine().trim();
            String level = switch (lvlChoice) {
                case "1" -> "초급";
                case "2" -> "중급";
                case "3" -> "고급";
                default  -> "초급";
            };

            System.out.print("언어 선택 (1: 한글, 2: 영어, 3: 일본어)> ");
            String langChoice = sc.nextLine().trim();
            String language = switch (langChoice) {
                case "1" -> "한글";
                case "2" -> "영어";
                case "3" -> "일본어";
                default  -> "한글";
            };

            String textSql = "SELECT id, content FROM texts "
                           + "WHERE level = ? AND language = ? "
                           + "ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY";
            int textId = -1;
            String originalText = "";

            try (PreparedStatement pstmt = conn.prepareStatement(textSql)) {
                pstmt.setString(1, level);
                pstmt.setString(2, language);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        textId = rs.getInt("id");
                        originalText = rs.getString("content");
                    }
                }
            }

            if (textId == -1) {
                System.out.println("해당 조건에 맞는 문제가 없습니다.");
                return;
            }

            System.out.println("\n--- 아래 문장을 입력하세요 ---");
            System.out.println(originalText);
            System.out.println("--------------------------------");
            System.out.print("준비되면 엔터를 누르세요...");
            sc.nextLine();

            long startTime = System.currentTimeMillis();
            System.out.print("입력> ");
            String typed = sc.nextLine();
            long endTime = System.currentTimeMillis();

            double elapsedSeconds = (endTime - startTime) / 1000.0;
            int typedChars = typed.length();
            double speed = TypingUtils.calculateSpeed(typedChars, elapsedSeconds);
            double accuracy = TypingUtils.calculateAccuracy(originalText, typed);

            System.out.printf("결과: 속도 = %.2f WPM, 정확도 = %.2f%%%n", speed, accuracy);

            String insertSql = "INSERT INTO results (user_id, text_id, speed, accuracy) "
                             + "VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt2 = conn.prepareStatement(insertSql)) {
                pstmt2.setInt(1, userId);
                pstmt2.setInt(2, textId);
                pstmt2.setDouble(3, speed);
                pstmt2.setDouble(4, accuracy);
                pstmt2.executeUpdate();
            }
            System.out.println("결과가 저장되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}