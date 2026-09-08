package labs.pm.app;

import labs.pm.data.Product;
import labs.pm.data.ProductNameLenghtComparator;

import static labs.pm.data.Rating.*;

import java.math.BigDecimal;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Shop {
    public static void main(String[] args) {

        Product p1 = new Product(1,"Laptop",BigDecimal.valueOf(100000));
//
        Product p3 = new Product(3,"Tablet",BigDecimal.valueOf(20000),TWO_STAR);
        Product p4 = new Product();
        Product p2 = new Product(2,"Smartphone",BigDecimal.valueOf(50000), FIVE_STAR);
        Product p5 = new Product(4,"Smartphone",BigDecimal.valueOf(50000), FIVE_STAR);
//
//        p3 = p3.applyRating(THREE_STAR);
//
//        System.out.println(p2.equals(p5));



//        String a = "marwane";
//        String b = new String("marwane");
//        System.out.println(b);
//        System.out.println(a);
//        System.out.println(a==b);

//        Product[] products = new Product[]{p5,p3,p2,new Product(5,"Smartphone",BigDecimal.valueOf(50000), FIVE_STAR),new Product(6,"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaa",BigDecimal.valueOf(50000), FIVE_STAR)};
//        Arrays.sort(products,new ProductNameLenghtComparator());
//        for (Product product : products) {
//            System.out.println(product);
//        }


        /*Map<String, Integer>  map = new HashMap<>();
        map.put("pomme",3);
        map.put("orange",2);
        map.put("banane",1);
        map.put("kiwi",3);

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<String,Integer>> entries = map.entrySet();

        keys.add("ananas");
        System.out.println(keys);
        System.out.println(values);
        System.out.println(entries);*/

//        Product[] products = {p1,p2,p3,p4,p5};
//        List<Product> list1 = Arrays.asList(products);

        //list1.set(1,new Product());
//        products[1] = null;
//        products[3] = null;
        //products[2] = new Product();

//        Set<Product> set1 = Set.of(products);
//
//       for(Product i : products){
//           System.out.println(i);
//       }
//        System.out.println("*************************");
//
//       for(Product j : list1){
//            System.out.println(j);
//       }
//
//        System.out.println("*************************");
//
//        for(Product k : set1){
//            System.out.println(k);
//        }



    Map<String,Integer> map = new HashMap<>();
    map.put("marwane",1);
    map.put("ilhame",2);
    map.put("salma",6);

    Set<Map.Entry<String,Integer>> entries = map.entrySet();


//    for (Map.Entry<String,Integer> i : entries){
//        System.out.println(i.getKey()+" "+i.getValue());
//    }

        Iterator<Map.Entry<String,Integer>> it = entries.iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> i = it.next();
            System.out.println(i.getKey()+" "+i.getValue());
        }









    }


}