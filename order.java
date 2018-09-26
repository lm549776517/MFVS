
public class order
{
    private String orderID;
    private String createDate;
    private String dateShipped;
    private String userName;
    User user = new User();
    private boolean shipStatus;
    private int productID;
    private String productName;
    private int Quantity;
    private float unitCost;
    private float subtotal;

    public order(String orderID,String createDate,User user,String dateShipped,
                 int productID,String productName,int Quantity,float unitCost,
                 float subtotal)
    {
        this.user.getUserName() = userName;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
