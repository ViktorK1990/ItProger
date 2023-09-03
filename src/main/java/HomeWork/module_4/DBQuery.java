package HomeWork.module_4;

import java.sql.*;

public class DBQuery {

    public void isConnected(Connection connection) {
        try {
            System.out.println(connection.isValid(1000));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void CreateTableUsers(Connection connection) {
        String query = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "login VARCHAR(30) NOT NULL," +
                "pass VARCHAR(30) NOT NULL);";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table users created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CreateTableItems(Connection connection) {
        String query = "CREATE TABLE IF NOT EXISTS items (" +
                "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "title VARCHAR(50) NOT NULL," +
                "price INT," +
                "category VARCHAR(30));";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table items created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void CreateTableOrders(Connection connection) {
        String query = "CREATE TABLE IF NOT EXISTS orders (" +
                "user_id INT NOT NULL," +
                "item_id INT NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES users(id)," +
                "FOREIGN KEY (item_id) REFERENCES items(id))" +
                "ENGINE=INNODB;";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table orders created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUsersDate (Connection connection, String login, String pass) {
        String query = "INSERT INTO users(id,login, pass) VALUES" +
                "(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,pass);
            preparedStatement.executeUpdate();
            System.out.println("User added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addItemsDate (Connection connection, String title, int price, String category) {
        String query = "INSERT INTO items(title, price, category) VALUES" +
                "(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,title);
            preparedStatement.setInt(2,price);
            preparedStatement.setString(3,category);
            preparedStatement.executeUpdate();
            System.out.println("Item added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addOrderDate (Connection connection, int user, int item) {
        String query = "INSERT INTO orders(user_id, item_id) VALUES" +
                "(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user);
            preparedStatement.setInt(2, item);
            preparedStatement.executeUpdate();
            System.out.println("Order added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getData (Connection connection) {
        String query = "SELECT CONCAT(users.login,' - ', items.title) AS 'Все заказы' FROM orders " +
                "JOIN users ON orders.user_id=users.id AND users.login='John' " +
                "JOIN items ON orders.item_id=items.id;";

        try {
            Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()) {
               System.out.println(resultSet.getString("Все заказы"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
