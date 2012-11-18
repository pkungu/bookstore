package bookstore;
import java.sql.*;
import javax.swing.*;

public class BookstoreManagerComp {

    // Cart.
    protected Cart cart = new Cart();
    public Cart Cart() { return cart; }
    
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
        InitializeConnection();
    }

    //
    //  Querying Methods
    //
    
    // Test.
    public void QueryAllBooks(JTable j)
    {
        try
        {
            j.setModel(getResultSetTableModel("select * from `books`"));
        }
        catch (SQLException ex) {}
    }
    
    // 
    public void Query(JTable j, String sT, String bT)
    {
        String searchText = sT;
        String byText = bT;
        String sql;
        if (searchText.equals(""))
        {
            sql = "select * from `books`";
        }
        else
        {
            sql = "select * from `books` "
                    + "where " + byText + 
                    " like '%" + searchText +"%'";
        }
        try
        {
            j.setModel(getResultSetTableModel(sql));
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    //
    //  Connection Management Methods
    //
    
    /**
     * Method to initialize the connection to the database.
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
    }
    
    /**
     * Terminate.
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
    // Handle generation of our custom TableModel
    //
    private ResultSetTableModel getResultSetTableModel(String query)
        throws SQLException
    {
	// If we've called close(), then we can't call this method
	if (_connection == null)
        {
	    throw new IllegalStateException("Connection already closed.");
        }

	// Create a Statement object that will be used to excecute the query.
	// The arguments specify that the returned ResultSet will be 
	// scrollable, read-only, and insensitive to changes in the db.
	Statement statement =
	    _connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				       ResultSet.CONCUR_READ_ONLY);
	// Run the query, creating a ResultSet
	ResultSet r = statement.executeQuery(query);
	// Create and return a TableModel for the ResultSet
	return new ResultSetTableModel(r);
    }
}
