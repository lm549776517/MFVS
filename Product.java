import java.util.*;
   public class Product
   {
        private String productID;
        private String productName;
        private String saleMethod;
        private String shelfLife;
        private String source;
        private float price;
        private String type;
        private int quantity;
        private String addDate;
        private ArrayList<Product> productList;
        
    public Product(String productName,String saleMethod,String shelfLife,
                    String source,float price,String type,
                    String addDate,int quantity)
    {
        // initialise instance variables
        this.productID = productID;
        this.productName = productName;
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
    
    public String getShelfLife()
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
    
    public String getAddDate()
    {
        return addDate;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    public void displayProduct()
    {
      
    }
    
    public void Select(String productName)
    {
      
    }
}