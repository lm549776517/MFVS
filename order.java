import java.util.*;
public class order
{
    private String productID;
    private String productName;
    private float Quantity;
    private float unitCost;
    
    public order(String productID,String productName,float Quantity,float unitCost)
    {
        this.productID = productID;
        this.productName = productName;
        this.Quantity = Quantity;
        this.unitCost = unitCost;
    }
    
    public String getProductID()
    {   
        return productID;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public float getQuantity()
    {
        return Quantity;
    }
    
    public float getUnitCost()
    {
        return unitCost;
    }
}
