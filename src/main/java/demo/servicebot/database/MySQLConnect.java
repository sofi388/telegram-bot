package demo.servicebot.database;

import java.sql.*;

public class MySQLConnect {

    public String runSQL(String request){
        String res = " ";
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/films?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","12345");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from films where genre = " + "'"+ request + "'");

            while(rs.next()) {
                System.out.println(rs.getInt(1));//+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4) +"  "+rs.getString(5));
                res = rs.getString("name");
            }
            // res = rs.getString(1);
            con.close();
            System.out.println(res);

            return res;//rs.getString(1);
        }catch(Exception e){ System.out.println(e);}

        return res;
    }
    public static void main(String args[]){
        MySQLConnect connect = new MySQLConnect();
        String res = connect.runSQL("Comedy");
       // System.out.println(result);
    }
}

// База данных: фильмы
