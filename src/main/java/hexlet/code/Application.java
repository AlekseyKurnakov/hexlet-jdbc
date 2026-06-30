package hexlet.code;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:hexlet_test")) {

            String sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";

            try (Statement statement = conn.createStatement()) {
                statement.execute(sql);
            }

            User user1 = new User ("Sarah", "63546545");
            User user2 = new User ("Tommy", "52115651");
            User user3 = new User ("Maria", "96845121");
            User user4 = new User ("Jim", "333333333");

            UserDAO userDAO = new UserDAO(conn);

            userDAO.save(user1);
            userDAO.save(user2);
            userDAO.save(user3);
            userDAO.save(user4);

            User jim = userDAO.find(user4.getId()).get();

            userDAO.delete(jim.getId());

            String sql3 = "SELECT * FROM users";

            try (Statement statement3 = conn.createStatement()) {
                ResultSet resultSet = statement3.executeQuery(sql3);

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                    System.out.println(resultSet.getString("phone"));
                }
            }
        }
    }
}