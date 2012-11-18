package bookstore;
import java.util.*;

public class Cart {
    
    public int _id;
    protected List<Book> books = new ArrayList();
    
    public double currentTotal()
    {
        double total = 0;
        for (Book b : books)
        {
            total += b._price;
        }
        return total;
    }
    
    public void addToCart(Book b)
    {
        books.add(b);
    }
    
    public void addToCart(Book b, int count)
    {
        for (int i = count; i != 0; i--)
        {
            books.add(b);
        }
    }
    
    void removeFromCart(Book b)
    {
        books.remove(b);
    }
    
    public void RemoveBook(int location)
    {
        books.remove(location);
    }
    
    void removeFromCart(List<Book> toRemove)
    {
        books.removeAll(toRemove);
    }
    
    public void ClearCart()
    {
        books.removeAll(books);
    }
    
    public List<Book> retrieveBooksFromCart()
    {
        return books;
    }
}
