package assignment1.question1;

import java.sql.*;
public class Connection {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/stuff","root","dhruv123");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            String sql = "INSERT INTO table1 values(2,'aa','bb')" ;             //insert query
            stmt.executeUpdate(sql);

            //ResultSet rs=stmt.executeQuery("select * from table1");         //select query
            //while(rs.next())
             //   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
