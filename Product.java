import java.util.*;
public class Product
{
    private String productID;
    private String productName;
    private String category;
    private String saleMethod;
    private int shelfLife;
    private String source;
    private float price;
    private String type;
    private float quantity;
    private Date addDate;

    public Product(String productName,String category,String saleMethod,int shelfLife,
    String source,float price,String type,
    Date addDate,float quantity)
    {
        // initialise instance variables
        this.productName = productName;
        this.category = category;
        this.saleMethod = saleMethod;
        this.shelfLife = shelfLife;
        this.source = source;
        this.price = price;
        this.type = type;
        this.addDate = addDate;
        this.quantity = quantity;
        productID = productName + addDate;

    }

    public String getProductID()
    {
        return productID;
    }

    public String getProductName()
    {
        return productName;
    }

    public String getSaleMethod()
    {
        return saleMethod;
    }

    public int getShelfLife()
    {
        return shelfLife;
    }

    public String getSource()
    {
        return source;
    }

    public float getPrice()
    {
        return price;
    }

    public String getType()
    {
        return type;
    }

    public Date getAddDate()
    {
        return addDate;
    }

    public float getQuantity()
    {
        return quantity;
    }
}