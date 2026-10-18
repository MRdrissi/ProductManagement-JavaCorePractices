package labs.pm.app;

import labs.pm.data.*;

import static labs.pm.data.Rating.*;

import java.math.BigDecimal;
import java.util.*;
import java.time.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Shop {
    public static void main(String[] args) {


        ProductManager pm = new ProductManager(Locale.getDefault());
        System.out.println(ProductManager.getSupportedLocales());
        pm.changeLocale("ar-MA");

        Product p1 = pm.createProduct(101, "Tea",
                BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.printProductReport(101);
        p1 = pm.reviewProduct(101, 4, "Nice hot cup of tea");
        p1 = pm.reviewProduct(101, 2, "Rather weak tea");
        p1 = pm.reviewProduct(101, 4, "Fine tea");
        p1 = pm.reviewProduct(101, 4, "Good tea");
        p1 = pm.reviewProduct(101, Rating.FIVE_STAR.ordinal(), "Perfect tea");
        p1 = pm.reviewProduct(101, Rating.THREE_STAR.ordinal(), "Just add some lemon");
        pm.printProductReport(101);

        Product p2 = pm.createProduct(102, "Coffee",
                BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        p2 = pm.reviewProduct(p2, 3, "Coffee was ok");
        p2 = pm.reviewProduct(p2, 1, "Where is the milk?!");
        p2 = pm.reviewProduct(p2, 5, "It's perfect with ten spoons of sugar!");
        pm.printProductReport(p2);

        Product p3 = pm.createProduct(103, "Cake",
                BigDecimal.valueOf(3.99), Rating.NOT_RATED,
                LocalDate.now().plusDays(2));
        p3 = pm.reviewProduct(p3, 5, "Very nice cake");
        p3 = pm.reviewProduct(p3, 4, "Good, but I've expected more chocolate");
        p3 = pm.reviewProduct(p3, 5, "This cake is perfect!");
        pm.printProductReport(p3);

        Product p4 = pm.createProduct(104, "Cookie",
                BigDecimal.valueOf(2.99), Rating.NOT_RATED,
                LocalDate.now());
        p4 = pm.reviewProduct(p4, 3, "Just another cookie");
        p4 = pm.reviewProduct(p4, 3, "Ok");
        pm.printProductReport(p4);

        Product p5 = pm.createProduct(105, "Hot Chocolate",
                BigDecimal.valueOf(2.50), Rating.NOT_RATED);
        p5 = pm.reviewProduct(p5, 4, "Tasty!");
        p5 = pm.reviewProduct(p5, 4, "No bad at all");
        pm.printProductReport(p5);

        Product p6 = pm.createProduct(106, "Chocolate",
                BigDecimal.valueOf(2.50), Rating.NOT_RATED,
                LocalDate.now().plusDays(3));
        p6 = pm.reviewProduct(p6, 2, "Too sweet");
        p6 = pm.reviewProduct(p6, 3, "Better then cookie");
        p6 = pm.reviewProduct(p6, 2, "Too bitter");
        p6 = pm.reviewProduct(p6, 1, "I don't get it!");
        pm.printProductReport(p6);


        /*ProductManager pm = new ProductManager(Locale.getDefault());

        Product p1 = pm.createProduct(101,"Tea",BigDecimal.valueOf(1.99), NOT_RATED);

        Product p2 = pm.createProduct(102,"Coffee",BigDecimal.valueOf(1.7), FIVE_STAR);
        Product p3 = pm.createProduct(103,"Donats",BigDecimal.valueOf(2.3),TWO_STAR,LocalDate.now().plusDays(2));
        Product p4 = pm.createProduct(1014,"Cookie",BigDecimal.valueOf(3.99), THREE_STAR,LocalDate.now());
        Product p6 = pm.createProduct(104,"Chocolate",BigDecimal.valueOf(2.99),FIVE_STAR);
        Product p7 = pm.createProduct(104,"Chocolate",BigDecimal.valueOf(2.99),FIVE_STAR,LocalDate.now().plusDays(2));
        Product p8 = p4.applyRating(FIVE_STAR);
        Product p9 = p1.applyRating(TWO_STAR);

        pm.printProductReport();
        p1 = pm.reviewProduct(p1,5,"Great Hot Cup of tea !");
        p1 = pm.reviewProduct(p1,4,"Great Hot Cup of tea !");
        p1 = pm.reviewProduct(p1,3,"Great Hot Cup of tea !");
        p1 = pm.reviewProduct(p1,4,"Great Hot Cup of tea !");
        p1 = pm.reviewProduct(p1,1,"Great Hot Cup of tea !");
        pm.printProductReport();*/
    }
}