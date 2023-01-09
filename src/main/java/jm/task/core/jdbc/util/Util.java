package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/javappex1";
    private static final String NAME_USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;
    private static final Statement statement;

    static {
        try {
            /*
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            */
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
            connection.setAutoCommit(false);
            if (!connection.isClosed()) {
                System.out.println("Connection with DataBase is established!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
