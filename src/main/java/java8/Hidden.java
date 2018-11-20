package java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

interface Fly {
    int height = 0;

    default void takeOff() {
        System.out.println("takeOff");
    }

    default void cruise() {
        System.out.println("cruise");
    }

    default void turn() {
        System.out.println("turn");
    }

    default void land() {
        System.out.println("land");
    }

    static void lauda() {
        System.out.println("lauda");
    }

}

interface Pussy {
    int height = 1;

    default void land() {
        System.out.println("wet");
    }
}

class ParentLund {
    public void land() {
        System.out.println("lauda");
    }
}


class Hidden {
    @Data
    @AllArgsConstructor
    static class Person {
        int age;
        String name;
    }

    public static void printSorted(List<Person> persons, Comparator<Person> comparator) {
        persons.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(12, "Sumit"));
        persons.add(new Person(10, "Sumit"));
        persons.add(new Person(20, "Bakri"));
        persons.add(new Person(21, "Divgandu"));

        //printSorted(persons, (first, second) -> first.getName().compareTo(second.getName()));

        //printSorted(persons, Comparator.comparing(Person::getName));
        //printSorted(persons, Comparator.comparing(Person::getName, Comparator.reverseOrder()).thenComparing(Person::getAge));


        System.out.println(persons.stream().collect(Collectors.groupingBy(person -> person.getName())));

        System.out.println(persons.stream().collect(Collectors.summingInt(Person::getAge)));

        System.out.println(persons.stream().collect(Collectors.groupingBy(Person::getName, mapping(Person::getAge, toSet()))));

        //System.out.println(persons.stream().collect(Collectors.mapping(person -> person)));

        persons.stream()
                .collect(Collectors.groupingBy(person -> person.getName(), summingInt(person-> person.getAge())));




    }
}
