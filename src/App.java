import java.sql.*;

// import the package
// load and register the driver --> com.mysql.jdbc.Driver
// Create connection
// create statement
// execute the query
// process the result
// close

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/world"; //ip and hostnumber
        
        //String query = "SELECT Name,Population FROM city where Population=2323"; 
        String query1 = "SELECT Name,Population FROM city Order By Name limit 1,10"; 

        Connection connection = DriverManager.getConnection(url, "root", "root");
        //you need a method that returns an object of connection cause Connection is an interface and you can't instantiate it

        Statement statement = connection.createStatement();
        //create statement returns the obj of statement

        ResultSet resultSet = statement.executeQuery(query1);
        
        //resultSet.next(); // to male pointer move the next value because currently it is at before start
       
        while(resultSet.next()){
        /*String name = resultSet.getString("Name");
        int population = resultSet.getInt("Population"); 
        System.out.println(name + " : " + population); */ 


        String userData = resultSet.getString("Name") + ":" + resultSet.getInt("Population");
        System.out.println(userData);
        }
        
        
        
        statement.close();
        connection.close();        

    }
    
}
