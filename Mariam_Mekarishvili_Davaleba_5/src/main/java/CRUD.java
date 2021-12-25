import java.sql.*;

public class CRUD {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_network_mariam_mekarishvili", "root", "root");
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void read() {
        Connection connection = getConnection();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from social_network_mariam_mekarishvili.user");
                printResultSet(resultSet);
                printMetaData(resultSet);

                closeConnection(connection);
            } catch (Exception ex) {
                ex.printStackTrace();
                // handle exception
            }
        }
    }
    public static void write() {
        Connection connection = getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into social_network_mariam_mekarishvili.user(full_name,birth_date,friends_count) values(?,?,?)");
                preparedStatement.setString(1, "mariam mekarishvili");
                preparedStatement.setDate(2, new java.sql.Date(2021, 12, 20));
                preparedStatement.setString(3, "19");
                int rowsEffected = preparedStatement.executeUpdate();

                if (rowsEffected < 1) {
                    System.out.println("Problem while inserting");
                } else {
                    System.out.println("Success while inserting");
                }

                preparedStatement.close();
                closeConnection(connection);
            } catch (Exception ex) {
                ex.printStackTrace();
                // handle exception
            }
        }
    }

    public static void update() {
        Connection connection = getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("update social_network_mariam_mekarishvili.user set friends_count=? where friends_count >= ?");
                preparedStatement.setString(1, "200");
                preparedStatement.setInt(2, 20);
                int rowsEffected = preparedStatement.executeUpdate();

                if (rowsEffected < 1) {
                    System.out.println("Problem while updating");
                } else {
                    System.out.println("Success while updating");
                }

                preparedStatement.close();
                closeConnection(connection);
            } catch (Exception ex) {
                ex.printStackTrace();
                // handle exception
            }
        }
    }

    public static void delete() {
        Connection connection = getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from social_network_mariam_mekarishvili.user where id=?");
                preparedStatement.setInt(1, 2);
                int rowsEffected = preparedStatement.executeUpdate();

                if (rowsEffected < 1) {
                    System.out.println("Problem while deleting");
                } else {
                    System.out.println("Success while deleting");
                }

                preparedStatement.close();
                closeConnection(connection);
            } catch (Exception ex) {
                ex.printStackTrace();
                // handle exception
            }
        }
    }

    private static void printResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("Users: ");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String fullName = resultSet.getString("full_name");
            Date birthDate = resultSet.getDate("birth_date");
            String friendsCount = resultSet.getString("friends_count");
            System.out.printf("user id: %d \n", id);
            System.out.printf("user full name: %s \n", fullName);
            System.out.printf("user friends: %s \n", friendsCount);
            System.out.printf("user birth date: %s \n", birthDate.toString());
        }
    }

    private static void printMetaData(ResultSet resultSet) throws SQLException {
        System.out.printf("Table name: %s \n", resultSet.getMetaData().getTableName(1));

        for (int i = 1; i<=resultSet.getMetaData().getColumnCount(); i++) {
            System.out.printf("Column: %s \n", resultSet.getMetaData().getColumnName(i));
        }
    }

    private static void closeConnection(Connection connection) throws SQLException {
        if (connection != null)
            connection.close();
    }
}
