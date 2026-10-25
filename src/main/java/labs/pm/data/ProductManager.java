package labs.pm.data;


import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

/**
 * @author marwane
 **/
public class ProductManager {

    private ResourceFormatter formatter;
    private static Map<String, ResourceFormatter> formatters =
            Map.of("en-GB", new ResourceFormatter(Locale.UK),
                    "en-US", new ResourceFormatter(Locale.US),
                    "fr-FR", new ResourceFormatter(Locale.FRANCE),
                    "ru-RU", new ResourceFormatter(new Locale("ru", "RU")),
                    "zh-CN", new ResourceFormatter(Locale.CHINA),
                    "fr-MA", new ResourceFormatter(Locale.getDefault()),
                    "ar-MA", new ResourceFormatter(new Locale("ar", "MA")));


    private Map<Product, List<Review>> products = new HashMap<>();

    private static int count = 0;

    public void changeLocale(String languageTag) {
        formatter = formatters.getOrDefault(languageTag, formatters.get("fr-MA"));
    }

    public static Set<String> getSupportedLocales() {
        return formatters.keySet();
    }

    public ProductManager(Locale locale) {
        this(locale.toLanguageTag());
    }

    public ProductManager(String languageTag) {
        changeLocale(languageTag);
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        Product product = new Food(id, name, price, rating, bestBefore);
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        Product product = new Drink(id, name, price, rating);
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product findProduct(int id) {
//        Product result = null;
//        for (Product product : products.keySet()) {
//            if (product.getId() == id) {
//                result = product;
//                break;
//            }
//        }
//        return result;

        return products.keySet()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseGet(() -> null);

    }

    public Product reviewProduct(int id, int stars, String comments) {
        return reviewProduct(findProduct(id), stars, comments);
    }

    public Product reviewProduct(Product product, int stars, String comments) {
        //if(reviews[reviews.length - 1] != null) reviews = Arrays.copyOf(reviews,reviews.length+5);
        List<Review> reviews = products.get(product);
        products.remove(product, reviews);
        reviews.add(new Review(Rateable.convert(stars), comments));
//        int sum = 0;
//        for (Review review : reviews) {
//            sum += review.rating().ordinal();
//        }
//        product = product.applyRating(Math.round((float) sum / reviews.size()));
//        double avg = reviews.stream()
//                        .mapToInt(p -> p.rating().ordinal())
//                        .average()
//                        .orElse(0);

        product = product.applyRating(
                (int) Math.round(
                        reviews.stream()
                                .mapToInt(p -> p.rating().ordinal())
                                .average()
                                .orElse(0)));

        products.put(product, reviews);
        return product;
    }

    public void printProductReport(int id) {
        printProductReport(findProduct(id));
    }

    public void printProductReport(Product product) {
        List<Review> reviews = products.get(product);
        Collections.sort(reviews);
        StringBuilder txt = new StringBuilder();

        txt.append(formatter.formatProduct(product));
        txt.append('\n');
//        for (Review review : reviews) {
//            txt.append(formatter.FormatReview(review));
//            txt.append('\n');
//        }
//        if (reviews.isEmpty()) {
//            txt.append(formatter.getText("no.reviews"));
//            txt.append('\n');
//        }
        if (reviews.isEmpty()) {
            txt.append(formatter.getText("no.reviews") + '\n');
        } else {
            reviews.stream().forEach(r -> {
                txt.append(formatter.FormatReview(r));
                txt.append('\n');
            });
        }
        System.out.println(txt);
    }

    public void printProducts(Comparator<Product> sorter) {
//        List<Product> productList = new ArrayList<>(products.keySet());
//        productList.sort(sorter);
        StringBuilder txt = new StringBuilder();
//        for (Product product : productList) {
//            txt.append(formatter.formatProduct(product));
//            txt.append('\n');
//        }
        products.keySet()
                .stream()
                .sorted(sorter)
                .forEach(p -> {
                    txt.append(formatter.formatProduct(p) + '\n');
                });
        System.out.println(txt);
    }

    private static class ResourceFormatter {

        private Locale locale;
        private ResourceBundle resources;
        private DateTimeFormatter dateFormat;
        private NumberFormat moneyFormat;

        private ResourceFormatter(Locale locale) {
            this.locale = locale;
            resources = ResourceBundle.getBundle("labs.pm.data.resources", locale);
            dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
            moneyFormat = NumberFormat.getCurrencyInstance(locale);
        }

        private String formatProduct(Product product) {
            String type = (product instanceof Food) ?
                    resources.getString("food") :
                    resources.getString("drink");

            return MessageFormat.format(resources.getString("product"),
                    product.getName(),
                    moneyFormat.format(product.getPrice()),
                    product.getRating().getStars(),
                    dateFormat.format(product.getBestBefore()),
                    type);
        }

        private String FormatReview(Review review) {
            return MessageFormat.format(resources.getString("review"),
                    review.rating().getStars(),
                    review.comments());
        }

        private String getText(String key) {
            return resources.getString(key);
        }
    }


}
