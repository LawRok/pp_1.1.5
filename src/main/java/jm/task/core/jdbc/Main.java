package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;


public class Main {
    /**
     * Создание таблицы User(ов) с помощью Hibernate
     * Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
     * Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
     * Очистка таблицы User(ов)
     * Удаление таблицы
     */
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) throws SQLException {
        // DaoHibernate
        userService.createUsersTable();

        userService.saveUser("Manir", "Asari", (byte)49);
        userService.saveUser("Rival", "Kruloz", (byte)10);
        userService.saveUser("Xil", "Sevelov", (byte)20);
        userService.saveUser("Mira", "Sonoli", (byte)51);

        userService.removeUserById(1);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}

