import java.util.*;
/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cart
{
    private String dateAdded;
    private HashMap<Product, Integer> cartList;
    
    //miss dateAdded
    public Cart()
    {
       cartList = new HashMap<Product, Integer>();
    }
    
    public void addProduct(Product product, int quantity)
    {
        cartList.put(product, quantity);
    }
    
    public void deleteProduct(Product product)
    {
        cartList.remove(product);
    }
    
    public void updateQuantity(String productName,
                               int quantity)
    {
        
    }
    
    public void checkOut()
    {
        
    }
    
    public HashMap getCart()
    {
        return cartList;
    }
    
    public float calculateUnitPrice()
    {
        return 1;
        
    }
    
    public float calculateTotalPrice()
    {
        return 1;
    }
}
