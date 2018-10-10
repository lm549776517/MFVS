import java.util.*;
/**
 * Write a description of class productList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductList
{
    private ArrayList<Product> productList;

    /**
     * Constructor for objects of class productList
     */
    public ProductList()
    {
       productList = new ArrayList<Product>();
    }


    public void addProduct(String productName,String category,String saleMethod,int shelfLife,
                    String source,float price,String type,
                    Date addDate,float quantity)
    {
        Product product = new Product(productName,category,saleMethod,shelfLife,
                   source,price,type,addDate,quantity);
        productList.add(product);
    }
    
    public void removeProductAsID(String productID)
    {
        Iterator<Product> it = productList.iterator();
        while(it.hasNext())
        {
            Product product = it.next();
            if (product.getProductID().equals(productID))
            {
                it.remove();                
            }
        }          
    }
    
    public void removeProductAsName(String productName)
    {
        Iterator<Product> it = productList.iterator();
        while(it.hasNext())
        {
            Product product = it.next();
            if (product.getProductName().equals(productName))
            {
                it.remove();                
            }
        }          
    }
    
    public ArrayList<Product> getProductList()
    {
        return productList;
    }
    
    public void setProductName(Product product, String productName)
    {
        product.setProductName(productName);
    }
    
    public void setSaleMethod(Product product,String method)
    {
        product.setSaleMethod(method);
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
    
    public void setAddDate(Date AddDate)
    {
        addDate = AddDate;
        productID = productName + addDate;
    }
    
    public void setQuantity(float q)
    {
        quantity = q;
    }
}
