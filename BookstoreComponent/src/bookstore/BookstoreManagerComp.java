package bookstore;
import java.sql.*;
import javax.swing.*;

public class BookstoreManagerComp {

    // Cart.
    protected Cart cart = new Cart();
    public Cart Cart() { return cart; }
    
    // Model factory for result set.
    protected ResultSetTableModelFactory factory;
    public ResultSetTableModelFactory Factory() { return factory; }
    
    // MySQL stuff.
    protected Connection _connection = null;
    protected Statement _statement = null;
    protected PreparedStatement _prepStatement = null;
    protected ResultSet _resultSet = null;

    // Database URL, username, and pw.
    private String url = "jdbc:mysql://localhost:3306/bookstore";
    private String user = "root";
    private String pw = "";
    
    // Connection monitoring stuff.
    private boolean isTransacting = false;
    
    /**
     * Constructor and Initialization methods.
     **/
    public BookstoreManagerComp()
    {
        Initialize();
    }
    
    public void Initialize()
    {
        InitializeConnection();
        try 
        {
            factory = new ResultSetTableModelFactory(_connection);
        }
        catch (ClassNotFoundException | SQLException ex) { System.out.println("Initialization failed.");}
    }
    
    //
    //  Querying Methods
    //
    
    public void QueryTest(JTable j)
    {
        try
        {
            j.setModel(factory.getResultSetTableModel("select * from `books`"));
        }
        catch (SQLException ex) {}
    }
    
    
    
    //
    //  Connection Management Methods
    //
    
    /**
     * Method to initialize the connection to the database. May not be needed
     * in the actual manager class, probably in the ResultSet factory--
     * come back and re-examine this. May need to be moved.
     **/
    private void InitializeConnection()
    {
        try 
        {
            // Look up and instantiate the driver. Use classpath for driver location,
            // or add to project lookup.
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Set up connection.
            _connection = DriverManager.getConnection(url, user, pw);
            
            if (!_connection.isClosed()) 
            { System.out.println("Successfully connected to the database."); }
        } 
        catch (ClassNotFoundException ex) { System.out.println("Couldn't find the driver."); }
        catch (SQLException ex) { System.out.println("SQL Exception."); }
        catch (Exception ex) { System.out.println("Driver Exception."); }
        finally
        {
            try
            {
                factory = new ResultSetTableModelFactory(_connection);
            }
            catch (ClassNotFoundException | SQLException ex) { System.out.println("Exception at the end of InitializeConnection."); }
        }
    }
    
    /**
     * Similar situation to the method above.
     **/
    private void TerminateConnection()
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
