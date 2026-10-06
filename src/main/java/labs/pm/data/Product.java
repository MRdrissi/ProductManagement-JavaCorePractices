/**
 * @author marwa
 **/
package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.math.RoundingMode.HALF_UP;

public sealed abstract class Product permits Food, Drink  {

    private final int id;
    private final String name;
    private final BigDecimal price;
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private final Rating rating;

    //l'acces est package-private car Foctory est dans le meme pack pas la peine public
    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

//    Product(int id, String name, BigDecimal price) {
//        this(id,name,price,Rating.NOT_RATED);
//    }

//    public Product(){
//        this(0,"no name",BigDecimal.ZERO);
//    }

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

    public abstract Product applyRating(Rating newRating);

    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return
                id +
                ", " + name +
                ", " + price +
                ", " + getDiscount() +
                ", " + rating.getStars() + ", "+getBestBefore();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //ici l'utilisation equals de Objects verifie le param est non null avant comparaison
        //alors que dans le design de cette class c excessive puisque le nom ne peut pas etre non null
        //equals de la class de la class String suffit [this.name.equals(name,product.name)]
        if(o instanceof Product product) return id == product.id && Objects.equals(name, product.name);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
