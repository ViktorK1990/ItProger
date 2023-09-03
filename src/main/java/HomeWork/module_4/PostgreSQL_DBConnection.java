package HomeWork.module_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL_DBConnection {
        private  final String DB_HOST = "localhost";
        private  final String DB_PORT = "5432";
        private  final String DB_NAME = "itproger";
        private  final String DB_USER_NAME = "postgres";
        private  final String DB_PASSWORD = "12345";

        private Connection connection = null;

        public Connection getDBConnection() {
            String connectionQuery = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(connectionQuery, DB_USER_NAME, DB_PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

