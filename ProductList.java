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
                    int addDate,float quantity)
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
    
    public void setCategory(Product product, String category)
    {
        product.setCategory(category);
    }
    
    public void setSaleMethod(Product product,String method)
    {
        product.setSaleMethod(method);
    }
    
    public void setShelfLife(Product product,int shelfLife)
    {
        product.setShelfLife(shelfLife);
    }
    
    public void setSource(Product product,String source)
    {
        product.setSource(source);
    }
    
    public void setPrice(Product product,float price)
    {
        product.setPrice(price);
    }
    
    public void setDate(Product product,int date)
    {
        product.setAddDate(date);
    }
    
    public void setQuantity(Product product,float quantity)
    {
        product.setQuantity(quantity);
    }

    public void setType(Product product,String type)
    {
        product.setType(type);
    }
}
