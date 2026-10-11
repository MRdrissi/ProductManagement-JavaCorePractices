package labs.pm.data;


import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author marwane
 **/
public class ProductManager {

    private Product product;
    //private Review review;
    private Review[] reviews = new Review[5];
    private Locale locale;
    private ResourceBundle resources;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;
    private static int count = 0;

    public ProductManager(Locale locale) {
        this.locale = locale;
        resources = ResourceBundle.getBundle("labs.pm.data.resources",locale);
        dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        moneyFormat = NumberFormat.getCurrencyInstance(locale);
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore){
        product = new Food(id,name,price,rating,bestBefore);
        return product;
    }

    public Product createProduct(int id,String name,BigDecimal price,Rating rating){
        product = new Drink(id,name,price,rating);
        return product;
    }

//    public Product reviewProduct(Product product,Rating rating,String comments){
//        if(reviews[reviews.length - 1] == null){
//            reviews[count++] = new Review(rating,comments);
//        }else{
//            reviews = Arrays.copyOf(reviews,reviews.length+5);
//            reviews[count++] = new Review(rating,comments);
//
//        }
//        this.product = product.applyRating(rating);
//        return this.product;
//    }

    public Product reviewProduct(Product product,int stars,String comments){
        if(reviews[reviews.length - 1] != null) reviews = Arrays.copyOf(reviews,reviews.length+5);
        int sum=0 , i=0;
        boolean reviewed = false;
        while(i<reviews.length && !reviewed){
            if (reviews[i] == null) {
                reviews[i] = new Review(Rateable.convert(stars),comments);
                reviewed = true;
            }
            sum += reviews[i].rating().ordinal();
            i++;
        }
        this.product = product.applyRating(Math.round((float)sum/i));
        return this.product;
    }

//    public void printProductReport(){
//        StringBuilder txt = new StringBuilder();
//        txt.append(product);
//        txt.append('\n');
//        if(review != null){
//            txt.append(review);
//        }else{
//            txt.append("Not Reviewed");
//        }
//        txt.append('\n');
//        System.out.println(txt);
//    }

    public void printProductReport() {
        StringBuilder txt = new StringBuilder();
//        String type = (product instanceof Food ) ? resources.getString("food") :
//                          resources.getString("drink");
        txt.append(MessageFormat.format(resources.getString("product"),
                product.getName(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())));
        txt.append('\n');
        for(Review review : reviews){
            if(review == null){
                txt.append(resources.getString("no.reviews"));
                break;
            }
            txt.append(MessageFormat.format(resources.getString("review"),
                    review.rating().getStars(),
                    review.comments()));
            txt.append('\n');
        }

        txt.append('\n');
        System.out.println(txt);
    }


}
