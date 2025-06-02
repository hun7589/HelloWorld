package typing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * TextSeeder 클래스
 *  - insertKoreanTexts(): 한글 텍스트 삽입
 *  - insertEnglishTexts(): 영어 텍스트 삽입
 *  - insertJapaneseTexts(): 일본어 텍스트 삽입
 */
public class TextSeeder {

    public void insertKoreanTexts(Connection conn, String baseDirPath) {
        File baseDir = new File(baseDirPath);
        if (!baseDir.exists() || !baseDir.isDirectory()) {
            System.err.println("한글 텍스트 디렉토리를 찾을 수 없습니다: " + baseDirPath);
            return;
        }

        File[] files = baseDir.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null) {
            System.err.println("한글 디렉토리에서 파일을 읽을 수 없습니다: " + baseDirPath);
            return;
        }

        for (File file : files) {
            String fname = file.getName();
            try {
                if (fname.equals("level1.txt")) {
                    insertLevel1Words(conn, file, "한글");
                } else if (fname.equals("level2.txt")) {
                    insertLevel2Sentences(conn, file, "한글");
                } else if (fname.startsWith("level3_") && fname.endsWith(".txt")) {
                    insertLevel3Essay(conn, file, "한글");
                } else {
                    System.out.println("한글: 알 수 없는 파일 패턴: " + fname + " (무시)");
                }
            } catch (Exception e) {
                System.err.println("한글 파일 처리 중 에러: " + fname);
                e.printStackTrace();
            }
        }
        System.out.println("한글 텍스트 삽입 완료.");
    }

    public void insertEnglishTexts(Connection conn, String baseDirPath) {
        File baseDir = new File(baseDirPath);
        if (!baseDir.exists() || !baseDir.isDirectory()) {
            System.err.println("영어 텍스트 디렉토리를 찾을 수 없습니다: " + baseDirPath);
            return;
        }

        File[] files = baseDir.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null) {
            System.err.println("영어 디렉토리에서 파일을 읽을 수 없습니다: " + baseDirPath);
            return;
        }

        for (File file : files) {
            String fname = file.getName();
            try {
                if (fname.equals("level1.txt")) {
                    insertLevel1Words(conn, file, "Eng");
                } else if (fname.equals("level2.txt")) {
                    insertLevel2Sentences(conn, file, "Eng");
                } else if (fname.startsWith("level3_") && fname.endsWith(".txt")) {
                    insertLevel3Essay(conn, file, "Eng");
                } else {
                    System.out.println("영어: 알 수 없는 파일 패턴: " + fname + " (무시)");
                }
            } catch (Exception e) {
                System.err.println("영어 파일 처리 중 에러: " + fname);
                e.printStackTrace();
            }
        }
        System.out.println("영어 텍스트 삽입 완료.");
    }

    public void insertJapaneseTexts(Connection conn, String baseDirPath) {
        File baseDir = new File(baseDirPath);
        if (!baseDir.exists() || !baseDir.isDirectory()) {
            System.err.println("일본어 텍스트 디렉토리를 찾을 수 없습니다: " + baseDirPath);
            return;
        }

        File[] files = baseDir.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null) {
            System.err.println("일본어 디렉토리에서 파일을 읽을 수 없습니다: " + baseDirPath);
            return;
        }

        for (File file : files) {
            String fname = file.getName();
            try {
                if (fname.equals("level1.txt")) {
                    insertLevel1Words(conn, file, "일본어");
                } else if (fname.equals("level2.txt")) {
                    insertLevel2Sentences(conn, file, "일본어");
                } else if (fname.startsWith("level3_") && fname.endsWith(".txt")) {
                    insertLevel3Essay(conn, file, "일본어");
                } else {
                    System.out.println("일본어: 알 수 없는 파일 패턴(" + fname + ") → 무시합니다.");
                }
            } catch (Exception e) {
                System.err.println("일본어 파일 처리 중 오류: " + fname);
                e.printStackTrace();
            }
        }

        System.out.println("일본어 텍스트 삽입이 모두 완료되었습니다.");
    }

    private void insertLevel1Words(Connection conn, File file, String language) throws Exception {
        String level = "초급";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String title = line;
                String content = line;

                String sql = "INSERT INTO texts (title, level, language, content) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, title);
                    pstmt.setString(2, level);
                    pstmt.setString(3, language);
                    pstmt.setString(4, content);
                    pstmt.executeUpdate();
                }
            }
        }
        System.out.printf("Level 1 단어 삽입 완료 (레벨=%s, 언어=%s)%n", level, language);
    }

    private void insertLevel2Sentences(Connection conn, File file, String language) throws Exception {
        String level = "중급";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String title = line;
                String content = line;

                String sql = "INSERT INTO texts (title, level, language, content) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, title);
                    pstmt.setString(2, level);
                    pstmt.setString(3, language);
                    pstmt.setString(4, content);
                    pstmt.executeUpdate();
                }
            }
        }
        System.out.printf("Level 2 문장 삽입 완료 (레벨=%s, 언어=%s)%n", level, language);
    }

    private void insertLevel3Essay(Connection conn, File file, String language) throws Exception {
        String level = "고급";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String titleLine = br.readLine();
            if (titleLine == null) {
                System.err.println("빈 파일: " + file.getName());
                return;
            }
            String title = titleLine.trim();

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String content = sb.toString().trim();
            if (content.isEmpty()) {
                System.err.println("본문이 비어 있습니다: " + file.getName());
                return;
            }

            String sql = "INSERT INTO texts (title, level, language, content) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, title);
                pstmt.setString(2, level);
                pstmt.setString(3, language);
                pstmt.setString(4, content);
                pstmt.executeUpdate();
            }

            System.out.printf("%s 삽입 완료 (레벨=%s, 언어=%s)%n", file.getName(), level, language);
        }
    }
}