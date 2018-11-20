package java8;

import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Optionaljava {

    static class Customer {
        int id;
        String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Customer() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class CustomerDao {
        static List<Customer> customers;

        static {
            customers = new ArrayList<>();
            customers.add(new Customer(1, "Sumit"));
            customers.add(new Customer(2, "Amit"));
        }

        static Optional<Customer> getCustomerById(final int id) {
            /*
            return customers.stream()
                    .filter(customer -> customer.getId() == id)
                    .findFirst()
                    .orElseGet(()->null);
            */

            return customers.stream()
                    .filter(customer -> customer.getId() == id)
                    .findFirst();
        }

        static int getCustomerIdStartingWithS() {
            return customers.stream()
                    .filter(customer -> customer.getName().startsWith("s"))
                    .findFirst()
                    .map(Customer::getId)
                    .orElse(-1);

        }

        static String getCustomberByName(String name) {

            return customers.stream()
                    .filter(customer -> customer.getName().equals(name))
                    .findFirst()
                    .map(Customer::getName)
                    .orElse("NA");
        }


        static List<String> getCustomerNamesByIds(List<Integer> ids) {
            return ids.stream()
                    .map(CustomerDao::getCustomerById)
                    .filter(Optional::isPresent)
                    .map(optionalOfCustomer -> optionalOfCustomer.get().getName())
                    .collect(Collectors.toList());
        }


        static Optional<Double> getSum(Optional<Double> first, Optional<Double> second) {
            /*if (first.isPresent() && second.isPresent()) {
                return Optional.of(first.get() + second.get());
            } else if (first.isPresent()) {
                return Optional.of(first.get());
            } else if (second.isPresent()) {
                return Optional.of(second.get());
            } else return Optional.empty();
            */


            List<Optional<Double>> optionals = Arrays.asList(first, second);
            return optionals.stream()
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .reduce(Double::max);


        }

        static int sum(List<Number> nums) {

            Stream.of(1, 2, 3).collect(Collectors.toMap(num -> num, num -> num + 10));

            Stream<Integer> intStream = Stream.of(1,2,3,4);
            List<Integer> intList = intStream.collect(Collectors.toList());
            System.out.println(intList); //prints [1, 2, 3, 4]

            intStream = Stream.of(1,2,3,4); //stream is closed, so we need to create it again
            Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
            System.out.println(intMap);

            return nums.stream()

                    .mapToInt(Number::intValue)
                    .sum();
        }


    }

    public static void main(String[] args) {
        System.out.println(CustomerDao.getCustomerNamesByIds(Arrays.asList(1, 2, 3)));
    }

}
