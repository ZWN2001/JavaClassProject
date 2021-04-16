package Student.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private Connection conn;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/javatest?useSSL=false&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "Azuraluno";
    public DbConnection()
    {
        try
        {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        return this.conn;
    }
}


