
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends User
{
    // instance variables - replace the example below with your own
    Cart shopingCart = new Cart();

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String username, String password)
    {
        super(username, password);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void checkShopingCart()
    {
        shopingCart.getCart();
    }
    
    public void s()
    {
        
    }
}
