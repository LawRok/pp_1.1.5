package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    /**
     * Создание таблицы User(ов)
     * Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
     * Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
     * Очистка таблицы User(ов)
     * Удаление таблицы
     */
    private final static UserServiceImpl userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Finick", "Berezov", (byte)54);
        userService.saveUser("Lapit", "Revelev", (byte)11);
        userService.saveUser("Asana", "Livenson", (byte)37);
        userService.saveUser("Lima", "Quitess", (byte)22);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}

