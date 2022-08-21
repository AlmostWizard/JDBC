package JDBCDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    
    Connection connection = null;
    public void connect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/learndb", "root", "root");
    }

    public Student getStudent(int rollno) {

        
        try {
        String query = "Select stuName, Marks From student where rollno = " + rollno;
        Student s = new Student();
        s.rollno = rollno;
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/learndb", "root", "root");
        Statement aStatement = connection.createStatement();
        ResultSet resultSet = aStatement.executeQuery(query);
        resultSet.next();
        String name = resultSet.getString(1);
        int marks = resultSet.getInt(2);
        System.out.println(name + " : " + marks);
        return s;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
        
    }


    public void addStudent(Student s){

        String query1 = "Insert into student values (?,?,?)";
        PreparedStatement pstatement;
        try {
            
            pstatement = connection.prepareStatement(query1);
            pstatement.setInt(1, s.rollno);
            pstatement.setString(2, s.stuName);
            pstatement.setInt(3, s.marks);
            pstatement.executeUpdate();
        }
            catch (Exception e) {
                
                System.out.println(e);
            }
        
        }
}