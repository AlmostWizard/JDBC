import java.sql.*;
public class App2 {

    public static void main(String[] args) throws Exception {

        
        String name = "Palak";
        int eID = 3;
        int salary = 111111111;
        
        String query = "insert into employees (emp_id, first_name, emp_pay) values (" + eID + ",'" + name + "',"  +  salary + ")";
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/learndb";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(query);

        System.out.println(count + "row/s affected");
        
        statement.close();
        connection.close();

    }
    
}
