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
    //  Querying Methods
    //
    
    
    //
    //  Connection Management Methods
    //
    
    /**
     * Method to initialize the connection to the database. May not be needed
     * in the actual manager class, probably in the ResultSet factory--
     * come back and re-examine this. May need to be moved.
     **/
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
    
    /**
     * Similiar situation to the method above.
     **/
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
