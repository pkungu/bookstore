package bookstore;

public class Book {
    public int _id;
    public String _isbn;
    public String _title;
    public String _publisher;
    public String _authors;
    public int _quantity;
    public double _price;
    
    public Book() {}
    
    public Book(int id, String isbn, String title, String publisher,
            String authors, int quantity, double price)
    {
       _id = id;
       _isbn = isbn;
       _title = title;
       _publisher = publisher;
       _authors = authors;
       _quantity = quantity;
       _price = price;
    }
}
