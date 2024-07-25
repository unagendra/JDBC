package com.jdbc;
import java.sql.*;

public class FetchRecords {
    public static void main(String[] args) {

        //Create Connection
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String password="password";
        String sql="select * from student";

        try {
            Connection con=DriverManager.getConnection(url,uname,password);

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery(sql);

            //process the results

            while (rs.next()){
                System.out.print(rs.getInt("sid")+":"+rs.getInt("marks")+":"+rs.getString("sname"));
                System.out.println();
            }

            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
