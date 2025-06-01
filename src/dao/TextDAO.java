package src.dao;

import src.model.Text;
import src.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TextDAO {

    public static List<Text> getTextsByLevelAndLanguage(String level, String language) {
        List<Text> list = new ArrayList<>();
        String sql = "SELECT id, title, content FROM texts WHERE difficulty_level = ? AND lang = ? ORDER BY DBMS_RANDOM.VALUE";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, level);
            pstmt.setString(2, language);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                list.add(new Text(id, title, content));
            }

        } catch (SQLException e) {
            System.out.println("텍스트 조회 오류: " + e.getMessage());
        }

        return list;
    }
}
