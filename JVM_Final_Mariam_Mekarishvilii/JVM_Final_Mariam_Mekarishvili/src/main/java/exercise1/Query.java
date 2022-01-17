package exercise1;

public class Query {

    public static final String createAnimalTable =
            "CREATE TABLE IF NOT EXISTS Animal(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, weight INT NOT NULL, PRIMARY KEY(id))";
    public static final String insertAnimal =
            "INSERT INTO Animal VALUES(?, ?, ?)";
}
