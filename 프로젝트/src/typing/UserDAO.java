package typing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // 회원가입
    public boolean register(Connection conn, String username, String password) throws Exception {
        String checkSql = "SELECT COUNT(*) AS cnt FROM users WHERE username = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            checkStmt.setString(1, username);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt("cnt") > 0) {
                    return false;
                }
            }
        }
        String insertSql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.executeUpdate();
        }
        return true;
    }

    // 로그인
    public int login(Connection conn, String username, String password) throws Exception {
        String sql = "SELECT id FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        return -1;
    }
}