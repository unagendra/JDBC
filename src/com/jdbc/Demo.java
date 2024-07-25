package com.jdbc;
import java.sql.*;

/**
 * 0. Load the DB Driver (Maven central Repo)
 * 1.Import package
 * 2.Load Driver
 * 3.Register Driver
 * 4.Create Connection
 * 5.Create Statement
 * 6.Execute Statement
 * 7. Close Connection
 */
public class Demo {


    public static void main(String[] args) {

       // Load and Register Driver(Optional)
//        try {
//            Class.forName("org.postgresql.Driver");
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Class not Found");
//        }

        //Create Connection
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String password="password";
        String sql="select sname from student where sid=1";

        try {
            Connection con=DriverManager.getConnection(url,uname,password);

            //Create Statement-Creates a Statement object for sending SQL statements to the database.
            // SQL statements without parameters are normally executed using Statement objects
            Statement st=con.createStatement();

            //Execute Statement
            ResultSet rs= st.executeQuery(sql);

            //process the results
            //System.out.println(rs.next());

            //points the pointer to first record
            rs.next();
            String name=rs.getString("sname");
            System.out.println("Name of the student is:"+name);

            //Close Connection
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



       // System.out.println("Connection Established!");



    }
}