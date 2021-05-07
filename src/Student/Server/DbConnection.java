package Student.Server;

import java.sql.*;

public class DbConnection {
    private Connection conn;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/exam?useSSL=false&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "Azuraluno";
    private Statement statement;
    private Statement statement1;
    private Statement statement2;


    public DbConnection() {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            statement1 = conn.createStatement();
            statement2 = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    public void update(String sql) throws SQLException {
        statement.executeUpdate(sql);
    }

    public ResultSet query1(String sql) throws SQLException {
        return statement1.executeQuery(sql);
    }

    public void update1(String sql) throws SQLException {
        statement1.executeUpdate(sql);
    }

    public ResultSet query2(String sql) throws SQLException {
        return statement2.executeQuery(sql);
    }

    public void update2(String sql) throws SQLException {
        statement2.executeUpdate(sql);
    }


    public void close() throws SQLException {
        if (conn != null)
            conn.close();
    }

    public Connection getConnection() {
        return this.conn;
    }
}


