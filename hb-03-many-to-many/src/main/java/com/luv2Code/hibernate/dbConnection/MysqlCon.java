package com.luv2Code.hibernate.dbConnection;
import java.sql.*;

class MysqlCon{
public static void main(String args[]){
try{
Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hb-01-one-to-one-uni","root","password");

System.out.println("Connection Sucessfull"+con);

//Statement stmt=con.createStatement();

//ResultSet rs=stmt.executeQuery("select * from emp");
con.close();

}catch(Exception e){ System.out.println(e);}

}
}