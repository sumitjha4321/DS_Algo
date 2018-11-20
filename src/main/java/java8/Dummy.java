package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Dummy {

    static class Person {
        int id;
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {

            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Person(int id, String name) {

            this.id = id;
            this.name = name;
        }
    }

    static interface Criteria {
        boolean test(Person p);
    }

    /*static void printPerson(List<Person> persons, Criteria criteria) {
        for (Person person : persons) {
            if (criteria.test(person)) {
                System.out.println(person.toString());
            }
        }
    }*/

    static <T> void printPerson(List<T> persons, Predicate<T> predicate) {
        for (T person : persons) {
            if (predicate.test(person)) {
                System.out.println(person.toString());
            }
        }
    }

    static <T> void printPerson(List<T> persons, Predicate<T> predicate, Consumer<T> consumer) {
        for (T person : persons) {
            if (predicate.test(person)) {
                consumer.accept(person);
            }
        }
    }

    static <T, R> void printPerson(List<T> persons, Predicate<T> predicate, Function<T, R> function, Consumer<R> consumer) {
        for (T person : persons) {
            if (predicate.test(person)) {
                R data = function.apply(person);
                consumer.accept(data);
            }
        }


        persons.stream()
                .filter(predicate)
                .map(function)
                .forEach(consumer);
    }


    public static boolean isPrime(int n) {

        System.out.println("isprime called for n = " + n);

        return n > 1 && IntStream.range(2, n - 1).noneMatch(i -> n % i == 0);

    }

    public static double compute(int n, int k) {

        return Stream.iterate(n, num -> num + 1)
                .filter(Dummy::isPrime)
                .mapToDouble(Math::sqrt)
                .limit(k)
                .sum();

    }


    public static void main(String[] args) {

        //System.out.println(compute(1, 5));

        Stream.iterate(1, e -> e*4).limit(5).forEach(System.out::println);


        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Sumit"));
        persons.add(new Person(2, "Divgandu"));

        //printPerson(persons, person -> person.getName().startsWith("S"));

        //printPerson(persons, person -> person.getName().startsWith("S"), System.out::println);

        // printPerson(persons, person -> person.getName().startsWith("S"), person -> person.getName() ,System.out::println);


    }
}
