package labs.pm.data;

import javax.management.MBeanTrustPermission;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author marwane
 **/
public class ProductManager {

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore){
        return new Food(id,name,price,rating,bestBefore);
    }

    public Product createProduct(int id,String name,BigDecimal price,Rating rating){
        return new Drink(id,name,price,rating);
    }
}
