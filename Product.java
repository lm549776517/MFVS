import java.util.*;
   public class Product
   {
        private int productID;
        private String productName;
        private String saleMethod;
        private String shelfLife;
        private String source;
        private float price;
        private String type;
        
    public Product(int productID,String productName,String saleMethod,String shelfLife,
                    String source,float price,String type)
    {
        // initialise instance variables
        this.productID = productID;
        this.productName = productName;
        this.saleMethod = saleMethod;
        this.shelfLife = shelfLife;
        this.source = source;
        this.price = price;
        this.type = type;
        
    }
    
    public int getProductID()
    {
        return productID;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public String getsaleMethod()
    {
        return saleMethod;
    }
    
    public String getshelfLife()
    {
        return shelfLife;
    }
    
    public String getsource()
    {
        return source;
    }
    
    public float getprice()
    {
        return price;
    }
    
    public String gettype()
    {
        return type;
    }
    
    public void displayProduct()
    {
      
    }
    
    public void Select(String productName)
    {
      
    }
}
