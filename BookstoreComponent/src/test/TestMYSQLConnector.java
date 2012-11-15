package test;
import java.sql.*;

public class TestMYSQLConnector {

    /**
     * Just a test class to see if the database and MySQL driver is set up
     * correctly. Be sure to have the MySQL driver installed and the class paths
     * set to the driver location, and make sure this all corresponds to the Java
     * JDK version you will be using!
     **/
  public static void main(String args[]) {
    Connection con = null;

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      con = DriverManager.getConnection("jdbc:mysql:///test", "root", "");

      if(!con.isClosed())
        System.out.println("Successfully connected to MySQL server...");

    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    } finally {
      try {
        if(con != null)
          con.close();
      } catch(SQLException e) {}
    }
  }
}