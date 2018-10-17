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
    private HashMap<String, Float> unitPrice;
    private ArrayList<OrderList> orderHistory;
    private float totalprice;
    private float unitprice;
    //miss dateAdded
    public Cart()
    {
       cartList = new HashMap<Product, Float>();
       unitPrice = new HashMap<String, Float>();
       orderHistory = new ArrayList<>();
       totalprice = 0;
       unitprice = 0;
    }
    
    public void addProduct(Product product, float quantity)
    {
        String name = product.getProductName();
        unitprice = quantity * product.getPrice();
        cartList.put(product, quantity);
        unitPrice.put(name, unitprice);
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
        HashMap newCartList = new HashMap<Product, Float>();
        cartList = newCartList;
    }
    
    public HashMap<Product, Float> getCart()
    {
        return cartList;
    }
    
    public ArrayList getHistoryOrder()
    {
        return orderHistory;
    }
    
    public HashMap<String, Float> calculateUnitPrice()
    {
        return unitPrice;
    }
    
    public float calculateTotalPrice()
    {
        totalprice = 0;
        Iterator<Product> it = cartList.keySet().iterator();
        while(it.hasNext())
        {
            Product product = it.next();
            float price = product.getPrice(); 
            float quantity = cartList.get(product);
            totalprice += price * quantity;
        }
        return totalprice;
    }
}
