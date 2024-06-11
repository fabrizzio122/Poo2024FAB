
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private Connection connection;

    public Database(String dbName) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS GameResults ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "player1 TEXT NOT NULL,"
                   + "player2 TEXT NOT NULL,"
                   + "winner TEXT,"
                   + "score TEXT,"
                   + "status TEXT"
                   + ");";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertGameResult(String player1, String player2, String winner, String score, String status) {
        String sql = "INSERT INTO GameResults(player1, player2, winner, score, status) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, player1);
            pstmt.setString(2, player2);
            pstmt.setString(3, winner);
            pstmt.setString(4, score);
            pstmt.setString(5, status);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllGameResults() {
        String sql = "SELECT * FROM GameResults";
        ResultSet rs = null;

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
}
