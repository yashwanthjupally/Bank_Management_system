import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysql_boilerPlate {
    public static void main(String[] args) {

        //Database url
        String url = "jdbc:mysql://localhost:3306/mydatabase";

        // database credentials
        String username = "root";
        String password = "jupally123";

        //Establish the connection
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the database");

            // perform database operations

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
