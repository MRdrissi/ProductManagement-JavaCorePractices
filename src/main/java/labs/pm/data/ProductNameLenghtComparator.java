package labs.pm.data;

import java.util.Comparator;

/**
 * @author marwa
 **/
public class ProductNameLenghtComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getName().length(),o2.getName().length());
    }
}
