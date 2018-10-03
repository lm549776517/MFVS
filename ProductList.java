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


    public void addProduct(int productID,String productName,
                            String saleMethod,String shelfLife,
                            String source,float price,String type)
    {
        Product product = new Product(productID,productName,saleMethod,shelfLife,
                   source,price,type);
        productList.add(product);
    }
    
    public void removeProduct(int productID)
    {
        for (Product d : productList)
        {
            if (d.getProductID() == productID)
                productList.remove(d);
        }       
     
    }
}
