package ru.job4j.jdbc;

import ru.job4j.collection.Analize;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        ClassLoader loader = ConnectionDemo.class.getClassLoader();
        Properties prt = new Properties();
        InputStream io = loader.getResourceAsStream("app.properties");
        prt.load(io);

        String url = prt.getProperty("url");
        String login = prt.getProperty("login");
        String password = prt.getProperty("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
