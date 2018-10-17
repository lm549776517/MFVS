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
        private int addDate;
        
    public Product(String productName,String category,String saleMethod,int shelfLife,
                    String source,float price,String type,
                    int addDate,float quantity)
    {
        // initialise instance variables
        this.productID = productID;
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
    
    public int getAddDate()
    {
        return addDate;
    }
    
    public float getQuantity()
    {
        return quantity;
    }
    
    public void setProductName(String name)
    {
        productName = name;
        productID = productName + addDate;
    }
    
    public void setSaleMethod(String method)
    {
        saleMethod = method;
    }
    
    public void setShelfLife(int shelflife)
    {
        shelfLife = shelflife;
    }
    
    public void setSource(String Source)
    {
        source = Source;
    }
    
    public void setPrice(float Price)
    {
        price = Price;
    }
    
    public void setType(String Type)
    {
        type = Type;
    }
    
    public void setAddDate(int AddDate)
    {
        addDate = AddDate;
        productID = productName + addDate;
    }
    
    public void setQuantity(float q)
    {
        quantity = q;
    }
 
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    public String getCategory()
    {
        return category;
    }
}

