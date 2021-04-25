package Teacher.Server.DataBase;



import Teacher.Server.ServerMain;

import java.io.IOException;
import java.sql.*;

public class DB {
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static final String username = "root";
    static final String password = "Zhaoweining750";
    public static DB instance;
    private boolean hasInited=false;
    Connection connection;

    public DB() throws IOException, SQLException { //连接数据库，直接提供操作方法

        try {//加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("载入数据库驱动失败");
            e.printStackTrace();
            ServerMain.closeServer();
        }
        try {//连接数据库
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (Exception e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
            ServerMain.closeServer();
        }
        if (!hasInited){//初始化数据库
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + "questions" + " default charset utf8 COLLATE utf8_general_ci;");
                statement.executeUpdate("USE questions;");
                statement.executeUpdate("DROP TABLE IF EXISTS choice;");
                statement.executeUpdate("CREATE TABLE choice\n" +
                        "(\n" +
                        "    id         int auto_increment\n" +
                        "        primary key,\n" +
                        "    stem       char(255) not null,\n" +
                        "    optA       char(255) not null,\n" +
                        "    optB       char(255) not null,\n" +
                        "    optC       char(255) not null,\n" +
                        "    optD       char(255) not null,\n" +
                        "    mark       int       not null,\n" +
                        "    difficulty int       not null,\n" +
                        "    answer     char(1)      not null\n" +
                        ");");
//                statement.executeUpdate("CREATE TABLE test(id int);");
//                statement.executeUpdate( "alter table choice\n" +
//                                "\tadd constraint choice_pk\n" +
//                                "\t\tprimary key (id);");
                hasInited=true;
                System.out.println("初始化数据库成功");
            }catch (Exception e){
                System.out.println("初始化数据库失败");
                e.printStackTrace();
                ServerMain.closeServer();
            }
        }
        instance = this;
    }

    public ResultSet query(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public void update(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        if (connection != null) connection.close();
    }
}
