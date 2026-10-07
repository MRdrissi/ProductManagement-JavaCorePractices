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




        ProductManager pm = new ProductManager();

        Product p1 = pm.createProduct(101,"Tea",BigDecimal.valueOf(1.99), NOT_RATED);

//        Product p2 = pm.createProduct(102,"Coffee",BigDecimal.valueOf(1.7), FIVE_STAR);
//        Product p3 = pm.createProduct(103,"Donats",BigDecimal.valueOf(2.3),TWO_STAR,LocalDate.now().plusDays(2));
//        Product p4 = pm.createProduct(1014,"Cookie",BigDecimal.valueOf(3.99), THREE_STAR,LocalDate.now());
//        Product p6 = pm.createProduct(104,"Chocolate",BigDecimal.valueOf(2.99),FIVE_STAR);
//        Product p7 = pm.createProduct(104,"Chocolate",BigDecimal.valueOf(2.99),FIVE_STAR,LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(FIVE_STAR);
//        Product p9 = p1.applyRating(TWO_STAR);


        p1 = pm.reviewProduct(p1,5,"Great Hot Cup of tea !");
        pm.printProductReport();





    }
}