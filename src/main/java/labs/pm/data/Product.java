/**
 * @author marwa
 **/
package labs.pm.data;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class Product implements Comparable<Product> {

    private final int id;
    private final String name;
    private final BigDecimal price;
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private final Rating rating;


    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id,name,price,Rating.NOT_RATED);
    }

    public Product(){
        this(0,"no name",BigDecimal.ZERO);
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public Rating getRating(){
        return rating;
    }

//    public void setName(final String name){
//        this.name = name;
//    }
//
//    public void setId(final int id){
//        this.id = id;
//    }
//
//    public void setPrice(final BigDecimal price){
//        //price  = BigDecimal.ONE;
//        this.price = price;
//    }

    public BigDecimal getDiscount(){
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + getDiscount() +
                '}';
    }

    public Product applyRating(Rating newRating){
        return new Product(id,name,price,newRating);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Product other)) return false;
        return other.getId() == this.id;
    }


    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }
}
