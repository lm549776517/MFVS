import java.util.*;
/**
 * Write a description of class OrderList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrderList
{
    private ArrayList<Order> orderList;
    private int orderID;
    private String dateShipped;
    private boolean shipStatus;
    private float subtotal;
    
    /**
     * Constructor for objects of class OrderList
     */
    public OrderList()
    {
        Calendar c = Calendar.getInstance();
        orderID = c.get(Calendar.YEAR)+c.get(Calendar.MONTH)+c.get(Calendar.DATE)+c.get(Calendar.HOUR_OF_DAY)
        +c.get(Calendar.MINUTE)+c.get(Calendar.SECOND);
        
        dateShipped = "Tonight";
        shipStatus =false;
        subtotal = 0;
    }

    public void generateList(HashMap<Product, Float> cartList)
    {
        Iterator<Product> it = cartList.keySet().iterator();
        while(it.hasNext())
        {
            Product product= it.next();
            Order order = new Order(product.getProductID(),product.getProductName(), product.getQuantity()
            ,product.getPrice());
            orderList.add(order);
            subtotal = subtotal + order.getUnitCost();
        }
    }
    
    public ArrayList<Order> getList()
    {
        return orderList;
    }
}
