package labs.pm.app;

import labs.pm.data.*;

import static labs.pm.data.Rating.*;

import java.math.BigDecimal;
import java.util.*;
import java.time.*;
import java.util.function.ObjDoubleConsumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Shop {
    public static void main(String[] args) {

        Product p1 = new Drink(101,"Tea",BigDecimal.valueOf(1.99), THREE_STAR);
        Product p2 = new Drink(102,"Coffee",BigDecimal.valueOf(1.7), FIVE_STAR);
        Product p3 = new Food(103,"Donats",BigDecimal.valueOf(2.3),TWO_STAR,LocalDate.now().plusDays(2));
        Product p4 = new Food(1014,"Cookie",BigDecimal.valueOf(3.99), THREE_STAR,LocalDate.now());
        Product p6 = new Drink(104,"Chocolate",BigDecimal.valueOf(2.99),FIVE_STAR);
        Product p7 = new Food(104,"Chocolate",BigDecimal.valueOf(2.99),FIVE_STAR,LocalDate.now().plusDays(2));
        Product p8 = p4.applyRating(FIVE_STAR);
        Product p9 = p1.applyRating(TWO_STAR);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);

        System.out.println(p3.getBestBefore());

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        System.out.println(p7 instanceof Product);
        System.out.println(p7 instanceof Food);
        System.out.println(p7 instanceof Object);

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");





        System.out.println(p6.equals(p7));





















    }


}