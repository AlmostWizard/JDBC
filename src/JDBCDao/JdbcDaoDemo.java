package JDBCDao;

public class JdbcDaoDemo {

    public static void main(String[] args) throws Exception {
        
        StudentDAO dao = new StudentDAO();
        //Student s1 = dao.getStudent(1);
        //System.out.println(s1.stuName);

        Student s2 = new Student();
        s2.stuName = "Aman";
        s2.marks = 77;
        s2.rollno = 4;
        dao.connect();
        dao.addStudent(s2);

    }


    
}
