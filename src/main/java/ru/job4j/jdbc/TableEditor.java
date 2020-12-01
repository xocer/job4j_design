package ru.job4j.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private ResourceBundle resourceBundle;

    public TableEditor(String properties) {
        this.resourceBundle = ResourceBundle.getBundle(properties);
        initConnection();
    }

    private void initConnection() {
        String url = resourceBundle.getString("url");
        String login = resourceBundle.getString("login");
        String password = resourceBundle.getString("password");
        String driver = resourceBundle.getString("driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Произошла ошибка при установке драйвера");
        }
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException throwables) {
            System.out.println("Ошибка в момент connection");
        }
    }

    public void createTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("create table + %s", tableName);
            statement.executeQuery(sql);
        } catch (SQLException throwables) {
            System.out.println("Ошибка в методе \"Создать таблицу\"");
        }
    }

    public void dropTable(String table) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("drop table + %s", table);
            statement.executeQuery(sql);
        } catch (SQLException throwables) {
            System.out.println("Ошибка в методе \"Удалить таблицу\"");
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s add column %s %s", tableName, columnName, type);
            statement.executeQuery(sql);
        } catch (SQLException throwables) {
            System.out.println("Ошибка в методе \"Добавить колонку\"");
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s drop column %s", tableName, columnName);
            statement.executeQuery(sql);
        } catch (SQLException throwables) {
            System.out.println("Ошибка в методе \"Удалить колонку\"");
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s rename column %s to %s", tableName, columnName, newColumnName);
            statement.executeQuery(sql);
        } catch (SQLException throwables) {
            System.out.println("Ошибка в методе \"Переименовать колонку\"");
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}