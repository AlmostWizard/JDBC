import java.sql.*;
public class App3 {

    public static void main(String[] args) throws Exception {

        
        String name = "Murmu";
        int eID = 5;
        int salary = 1232311;
        
        String query = "insert into employees (emp_id, first_name, emp_pay) values (?,?,?)";
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/learndb";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, eID);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, salary);

        int count = preparedStatement.executeUpdate();

        System.out.println(count + "row/s affected");
        
        preparedStatement.close();
        connection.close();

    }
    
}

