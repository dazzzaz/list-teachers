package Util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionChecker {
    /**
     * Подключение драйвера jdbc и получение подключения
     *
     * @return conn - подключения к базе данных
     */
    public static Connection mycon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = getConnection();
            System.out.println("Connection to DB succesfull!");
            return conn;
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Формирующаяся строка подключения
     * содержит URL, USERNAME, PASSWORD
     *
     * @return Connection - подключения к базе данных
     * @throws SQLException ошибка
     * @throws IOException ошибка
     *
     * @see Properties
     */
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (InputStream in = ConnectionChecker.class.getResourceAsStream("/database.properties")) {
            props.load(in);
        }

        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}
