package com.jdbc;

import java.sql.*;

public class CRUD {
    public static void main(String[] args) {
//insert into Student values (5,8,'piavn')
// delete from student where sid=5

        //Create Connection
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String password="password";
        String sql="update student set sname='Max' where sid=2";

        try {
            Connection con= DriverManager.getConnection(url,uname,password);

            Statement st=con.createStatement();

          boolean status= st.execute(sql);

            System.out.println(status);

            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
