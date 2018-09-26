
public class order
{
    private String orderID;
    private String createDate;
    private String dateShipped;
    private String userName;
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
        this.userName = user.getUserName();
        this.orderID = orderID;
        this.createDate = createDate;
        this.dateShipped = dateShipped;
        this.productID = productID;
        this.productName = productName;
        this.Quantity = Quantity;
        this.unitCost = unitCost;
        this.subtotal = subtotal;
    }

    public void displayOrder()
    {
        
    }
}
