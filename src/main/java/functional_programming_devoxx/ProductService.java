package functional_programming_devoxx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
@AllArgsConstructor
class Order {
    private Long id;
    private List<OrderLine> orderLines;
    private LocalDate creationDate;
}

@Data
@AllArgsConstructor
class OrderLine {
    private int id;
    private Product product;
    private int itemCount;
}

@AllArgsConstructor
@Getter
@Setter
class Product {
    Long id;
    String name;
    boolean isDeleted;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public boolean isNotDeleted() {
        return !isDeleted;
    }
}

interface ProductRepo {
    List<Long> getHiddenProductIds();
}

class ProductService {

    private static void testing(List<Order> orders) {



        /*
        groupingBy(orderLine -> orderLine.getProduct().getName())
            --> takes function to map orderline to string (underlying product name)
            --> will be Map <return value (after applying function), List<Supplied inputs>>

            --> egs:
            1. groupingBy(orderLine -> orderLine.getProduct().getName())
             --> Map<String, List<OrderLine>>

             2. groupingBy(orderLine -> orderLine.getProduct())
             --> Map<Product, List<OrderLine>>

             3. groupingBy(orderLine -> orderLine.getProduct(), mapping(orderLine -> orderLine.getId(), toList()))
             --> Map<Product, List<Long>>

             4. groupingBy(orderLine -> orderLine.getProduct(), mapping(orderLine -> orderLine.getId(), toSet()))
              --> groupingBy(orderLine -> orderLine.getProduct().getName())
              -- would have resulted in Map<String, List<OrderLine>>
              -- Now, the mapping function in groupingBy allows us to iterate over all vallues for each key in the map and
                 lets us transform each individual values and transform the result.

                 so, - groupingBy(orderLine -> orderLine.getProduct().getName())
                       returns Map <String, List<OrderLine>>
                      -  Now iterate over every OrderLine in each key, and apply the mapping function and collect the
                        result

         */


        Map<String, Integer> map =
                orders.stream()
                        .filter(order -> order.getCreationDate().isAfter(LocalDate.now().minusYears(1)))
                        .flatMap(order -> order.getOrderLines().stream())
                        .collect(Collectors.groupingBy(orderLine -> orderLine.getProduct().getName(), summingInt(orderLine -> 1)));


        System.out.println(map);


        Map<Product, Integer> map1 = orders.stream()
                .filter(order -> order.getCreationDate().isAfter(LocalDate.now().minusYears(1)))
                .flatMap(order -> order.getOrderLines().stream())
                .collect(Collectors.groupingBy(OrderLine::getProduct, summingInt(OrderLine::getItemCount)));

        Map<String, List<Product>> productListMap = orders.stream()
                .flatMap(order -> order.getOrderLines().stream())
                .map(OrderLine::getProduct)
                .collect(Collectors.groupingBy(Product::getName));

        Map<String, Integer> idsByName = orders.stream()
                .flatMap(order -> order.getOrderLines().stream())
                .map(OrderLine::getProduct)
                .collect(Collectors.groupingBy(Product::getName, summingInt(product -> Integer.parseInt(product.getId().toString()))));

        //System.out.println(idsByName);


    }

    private static Map<Product, Integer> getProductCount(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getCreationDate().isAfter(LocalDate.now().minusYears(1)))
                .flatMap(order -> order.getOrderLines().stream())
                .collect(Collectors.groupingBy(OrderLine::getProduct, summingInt(OrderLine::getItemCount)));
    }

    private static void getFrequentlyOrderedProduct(List<Order> orders) {

        // last year
        // ordered 10 times
        // not deleted
        // not contained in hidden products

        ProductRepo productRepo = null;

        getProductCount(orders).entrySet().stream()
                .filter(entry -> entry.getValue() > 10)
                .map(Map.Entry::getKey)
                .filter(Product::isNotDeleted)
                .filter(product -> !productRepo.getHiddenProductIds().contains(product.getId()))
                .collect(toList());
    }


    public static void main(String[] args) {
        List<OrderLine> orderLines = Arrays.asList(
                new OrderLine(1, new Product(1L, "Soap", false), 10),
                new OrderLine(2, new Product(2L, "Sugar", false), 20),
                new OrderLine(3, new Product(3L, "Oil", false), 30));


        List<OrderLine> orderLines2 = Arrays.asList(
                new OrderLine(11, new Product(10L, "Condom", false), 10),
                new OrderLine(12, new Product(1L, "Soap", false), 8));

        List<Order> orders = Arrays.asList(
                new Order(101L, orderLines, LocalDate.of(2017, 12, 22)),
                new Order(102L, orderLines2, LocalDate.of(2017, 10, 19)));

        getFrequentlyOrderedProduct(orders);


        //System.out.println(getFrequentlyOrderedProduct(orders));
    }


}
