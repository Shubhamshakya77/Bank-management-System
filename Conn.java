import java.sql.*;

public class Conn {

    Connection connection;

    Statement statement;
    public Conn(){


        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","@Tvs2055141");
            statement=connection.createStatement();

        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
