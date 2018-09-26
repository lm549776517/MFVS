import java.util.*;
/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cart
{
    private String cartID;
    private int productID;
    private int quantity;
    private String dateAdded;
    private User aUser;
    private ArrayList<String> cartList;
    
    //miss dateAdded
    public Cart(int productID,
                int quantity)
    {
        cartID = aUser.getUserName() + " cart";
        this.productID = productID;
        this.quantity = quantity;
        cartList = new ArrayList<>();
    }
    
    public void addProduct(String productName)
    {
        cartList.add(productName);
    }
    
    public void deleteProduct(String productName)
    {
        if (cartList.contains(productName))
        {
            cartList.remove(productName);
        }
        else
        {
            System.out.print("You don't hava this product, please ");
        }
    }
    
    public void updateQuantity(String productName,
                               int quantity)
    {
        
    }
    
    public void checkOut()
    {
        
    }
    
    public void displayCart()
    {
        
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
