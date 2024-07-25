package com.jdbc;
import java.sql.*;



public class PreparedStatement {
    public static void main(String[] args) {
        //Create Connection

        //sp - Callable statements

        //Data is coming from front end stored in variable
        String sname="Sugar";
        int marks=50;
        int sid=20;

        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String password="password";
        String sql="insert into Student values (?,?,?)";

        try {

            Connection con= DriverManager.getConnection(url,uname,password);

            //query is passed directly into prepared Statement
            //n object that represents a precompiled SQL statement.
            //A SQL statement is precompiled and stored in a PreparedStatement object.
            //This object can then be used to efficiently execute this statement multiple times.

          java.sql.PreparedStatement st=con.prepareStatement(sql);

          //replace the question marks with parameter index
          st.setInt(1,sid);
          st.setInt(2,marks);
          st.setString(3,sname);

            st.execute();

            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
