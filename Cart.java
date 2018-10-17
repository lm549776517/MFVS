import java.util.*;
/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cart
{
    private HashMap<Product, Float> cartList;
    private ArrayList<OrderList> orderHistory;
    
    //miss dateAdded
    public Cart()
    {
       cartList = new HashMap<Product, Float>();
       orderHistory = new ArrayList<>();
    }
    
    public void addProduct(Product product, Float quantity)
    {
        cartList.put(product, quantity);
    }
    
    public void deleteProduct(Product product)
    {
        cartList.remove(product);
    }
    
    public void updateQuantity(Product product,
                               Float quantity)
    {
        float newQuantity = cartList.get(product) + quantity;        
        cartList.put(product, newQuantity);
    }
    
    public void reduceQuantity(Product product,
                               Float quantity)
    {
        float newQuantity = cartList.get(product) - quantity;        
        cartList.put(product, newQuantity);
    }
    
    public void checkOut()
    {
        OrderList checkOut = new OrderList();
        checkOut.generateList(cartList);
        orderHistory.add(checkOut);
    }
    
    public HashMap getCart()
    {
        return cartList;
    }
    
    public ArrayList getHistoryOrder()
    {
        return orderHistory;
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
