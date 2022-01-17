package exercise1;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBHelper {

    private static String connectionUrl = "jdbc:mysql://localhost:3306/jvm_final_mariam_mekarishvili";
    private static Connection connection;

    public static void init() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(connectionUrl, "root", "");
            createNecessaryTables();
        } catch (Exception e) {

        }
    }

    private static void createNecessaryTables() {
        try {
            PreparedStatement statement = connection.prepareStatement(Query.createAnimalTable);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public static void insert(String name, int weight) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.insertAnimal);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, weight);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {

        }
    }
}
