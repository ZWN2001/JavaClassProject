package Teacher.Server.DataBase;



import Teacher.Server.Server;

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
            Server.closeServer();
        }
        try {//连接数据库
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (Exception e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
            Server.closeServer();
        }
        if (!hasInited){//初始化数据库
            try {
                Statement statement = connection.createStatement();
////                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + "questions" + " default charset utf8 COLLATE utf8_general_ci;");
////                statement.executeUpdate("USE questions;");
////                statement.executeUpdate("DROP TABLE IF EXISTS choice;");
////                statement.executeUpdate("DROP TABLE IF EXISTS judge;");
////                statement.executeUpdate("DROP TABLE IF EXISTS multiChoice;");
////                statement.executeUpdate("DROP TABLE IF EXISTS subjective;");
////
////                statement.executeUpdate("CREATE TABLE choice\n" +
////                        "(\n" +
////                        "    id         int auto_increment,\n " +
////                        "    stem       char(255) not null,\n" +
////                        "    optA       char(255) not null,\n" +
////                        "    optB       char(255) not null,\n" +
////                        "    optC       char(255) not null,\n" +
////                        "    optD       char(255) not null,\n" +
////                        "    mark       int       not null,\n" +
////                        "    difficulty int       not null,\n" +
////                        "    answer     char(8)   not null,\n" +
////                        "\t constraint choice_pk\n" +
////                        "    primary key (id)"+
////                        ");");
////
////                statement.executeUpdate("CREATE TABLE judge\n" +
////                        "(\n" +
////                        "\t id int  auto_increment,\n" +
////                        "\t stem char(255) not null,\n" +
////                        "\t mark int not null,\n" +
////                        "\t difficulty int not null,\n" +
////                        "\t answer char(8) not null,\n" +
////                        "\t constraint judge_pk\n" +
////                        "\t primary key (id)" +
////                        ");");
////
////                statement.executeUpdate("CREATE TABLE multiChoice\n" +
////                        "(\n" +
////                        "    id         int  auto_increment,\n " +
////                        "    stem       char(255) not null,\n" +
////                        "    optA       char(255) not null,\n" +
////                        "    optB       char(255) not null,\n" +
////                        "    optC       char(255) not null,\n" +
////                        "    optD       char(255) not null,\n" +
////                        "    mark       int       not null,\n" +
////                        "    difficulty int       not null,\n" +
////                        "    answer     char(50)  not null,\n " +
////                        "\t constraint multiChoice_pk\n" +
////                        "    primary key (id)"+
////                        ");");
////
////                statement.executeUpdate("CREATE TABLE subjective\n" +
////                        "(\n" +
////                        "\t id int  auto_increment,\n" +
////                        "\t stem char(255) not null,\n" +
////                        "\t mark int not null,\n" +
////                        "\t difficulty int not null,\n" +
////                        "\t answer char(255) not null,\n" +
////                        "\t constraint subjective_pk\n" +
////                        "\t primary key (id));");
////
//                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + "papers" + " default charset utf8 COLLATE utf8_general_ci;");
//                statement.executeUpdate("USE papers;");
//                statement.executeUpdate("DROP TABLE IF EXISTS paper;");
//                statement.executeUpdate("CREATE TABLE paper\n" +
//                        "(\n" +
//                        "\t id int auto_increment,\n" +
//                        "\t title char(255) not null,\n" +
//                        "\t mark int not null,\n" +
//                        "\t difficulty int not null,\n" +
//                        "\t ownerID int not null,\n" +
//                        "\t owner char(255) not null,\n" +
//                        "\t time char(255) not null,\n" +
//                        "\t examTime int not null,\n" +
//                        "\t questions text not null,\n" +
//                        "\t constraint paper_pk\n" +
//                        "  primary key (id)"+
//                        ");");
//
//                statement.executeUpdate("CREATE DATABASE  IF NOT EXISTS `exam`;");
//                statement.executeUpdate("USE `exam`;");
//                statement.executeUpdate("DROP TABLE IF EXISTS student;");
//                statement.executeUpdate("CREATE TABLE `student`(" +
//                        "`name` VARCHAR(25) NOT NULL," +
//                        "`account` VARCHAR(25) NOT NULL, " +
//                        "`password` VARCHAR(25) NOT NULL," +
//                        "`image` VARCHAR(255) DEFAULT NULL," +
//                        "PRIMARY KEY(`account`))");
//                statement.executeUpdate("DROP TABLE IF EXISTS `index`;");
//                statement.executeUpdate("CREATE TABLE `index`(" +
//                        "`student` VARCHAR(25) NOT NULL," +
//                        "`teacher` VARCHAR(25) DEFAULT NULL)\n");
//                statement.executeUpdate("DROP TABLE IF EXISTS `teacher`;");
//                statement.executeUpdate("CREATE TABLE `teacher`(" +
//                        "`name` VARCHAR(25) NOT NULL," +
//                        "`account` VARCHAR(25) NOT NULL," +
//                        "`password` VARCHAR(25) NOT NULL," +
//                        "`image` VARCHAR(255) DEFAULT NULL," +
//                        "PRIMARY KEY(`account`))\n");
//                statement.executeUpdate("DROP TABLE IF EXISTS `answer`;\n");
//                statement.executeUpdate("CREATE TABLE `answer`(" +
//                        "`student` VARCHAR(25) NOT NULL," +
//                        "`paperid` int NOT NULL," +
//                        "`answer` TEXT)\n");
//                update("DROP TABLE IF EXISTS `score`;");
//                update("CREATE TABLE `score`(" +
//                        "`student` VARCHAR(25) NOT NULL , " +
//                        "`paperid` int NOT NULL," +
//                        "`objectivescore` INT DEFAULT 0," +
//                        "`subjectivescore` INT DEFAULT 0," +
//                        "`sumScore` INT DEFAULT 0,\n" +
//                        "  primary key (sumScore));\n");
//                hasInited=true;
                System.out.println("初始化数据库成功");
            }catch (Exception e){
                System.out.println("初始化数据库失败");
                e.printStackTrace();
                Server.closeServer();
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
