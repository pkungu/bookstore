package bookstore;
import java.sql.*;

/**
 *
 * @author Cory
 */
public class BookstoreManagerComp {

    // MySQL stuff.
    protected Connection _connection = null;
    protected Statement _statement = null;
    protected PreparedStatement _prepStatement = null;
    protected ResultSet _resultSet = null;

    // Database URL, username, and pw.
    private String url = "jdbc:mysql://localhost:3306/books";
    private String user = "root";
    private String pw = "";
    
    // Connection monitoring stuff.
    private boolean isTransacting = false;
    
    
    //
    //  Connection Management Methods
    //
    public void InitializeConnection()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            _connection = DriverManager.getConnection(url, user, pw);
            if (!_connection.isClosed()) 
            { System.out.println("Successfully connected to the database."); }
        } 
        catch(Exception e) { System.out.println("Could not connect to database."); }
    }
    
    public void TerminateConnection()
    {
        try 
        { 
            if (_connection != null)
            {
                if (!isTransacting)
                {
                    _connection.close();
                }
                else
                {
                    try 
                    {
                        _connection.commit();
                    }
                    catch (Exception e) { System.out.println("Could not commit and close.");}
                    finally 
                    { 
                        _connection.close(); 
                    }
                }
            }
        }
        catch (Exception e) { System.out.println("Error in closing the connection."); }
    }
    
    //
    //
    //
}
