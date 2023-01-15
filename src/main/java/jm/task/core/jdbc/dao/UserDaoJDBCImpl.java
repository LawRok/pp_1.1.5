//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.mysql.cj.util.Util.*;
//
//public class UserDaoJDBCImpl implements UserDao {
//    private static final Connection conn = Util.getConnection();
//
//    public UserDaoJDBCImpl() {
//    }
//
//    // Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
//    public void createUsersTable() throws SQLException {
//        try (Statement statement = conn.createStatement()) {
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
//                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), last_name VARCHAR(45), age INT)");
//            conn.commit();
//        } catch (SQLException exc) {
//            conn.rollback();
//            exc.printStackTrace();
//        }
//    }
//
//    // Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
//    public void dropUsersTable() throws SQLException {
//        try (Statement statement = conn.createStatement()) {
//            statement.executeUpdate("DROP TABLE IF EXISTS users");
//            conn.commit();
//        } catch (SQLException exc) {
//            conn.rollback();
//            exc.printStackTrace();
//        }
//    }
//
//    // Добавление User в таблицу
//    public void saveUser(String name, String lastName, byte age) throws SQLException {
//        try (PreparedStatement prSt = conn.prepareStatement(
//                "INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)")) {
//            prSt.setString(1, name);
//            prSt.setString(2, lastName);
//            prSt.setByte(3, age);
//            prSt.execute();
//            conn.commit();
//        } catch (SQLException exc) {
//            conn.rollback();
//            exc.printStackTrace();
//        }
//    }
//
//    // Удаление User из таблицы ( по id )
//    public void removeUserById(long id) throws SQLException {
//        try (PreparedStatement prSt = conn.prepareStatement(
//                "DELETE FROM users WHERE id = ?")) {
//            prSt.setLong(1, id);
//            prSt.executeUpdate();
//            conn.commit();
//        } catch (SQLException exc) {
//            conn.rollback();
//            exc.printStackTrace();
//        }
//    }
//
//    // Получение всех User(ов) из таблицы
//    public List<User> getAllUsers() throws SQLException {
//        List<User> users = new ArrayList<>();
//        try (ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM users")) {
//            while (resultSet.next()) {
//                User user = new User(resultSet.getString("name"),
//                                    resultSet.getString("last_name"),
//                                    resultSet.getByte("age"));
//                user.setId(resultSet.getLong("id"));
//                users.add(user);
//            }
//            conn.commit();
//        } catch (SQLException exc) {
//            conn.rollback();
//            exc.printStackTrace();
//        }
//        return users;
//    }
//
//    // Очистка содержания таблицы
//    public void cleanUsersTable() throws SQLException {
//        try (Statement statement = conn.createStatement()) {
//            statement.executeUpdate("TRUNCATE TABLE users");
//            conn.commit();
//        } catch (SQLException exc) {
//            conn.rollback();
//            exc.printStackTrace();
//        }
//    }
//}
