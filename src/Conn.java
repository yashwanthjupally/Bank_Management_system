import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {

    String url = "jdbc:mysql:///bankmanagementsystem";
    String username = "root";
    String password = "jupally123";

    Connection conn;
    Statement statement;

    public Conn(){
        try{
            conn = DriverManager.getConnection(url,username,password);
            statement = conn.createStatement();

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
