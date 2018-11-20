package java8;


import java.util.ArrayList;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8 {

    public static String returnString() {
        return "a random string";
    }

    static interface GetAndReturn<T> {
        T get(T val);
    }


    public static void print(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }

    public static void print(Predicate<Integer> predicate) {
        System.out.println(predicate.test(100));
    }


    static interface Clickable {
        void click();
    }

    public static void greet(Clickable clickable) {
        clickable.click();
    }

    public static void main(String[] args) {


        Optional<String> optional = Optional.empty();
        String result = optional.filter((String str) -> str.equals("n"))
                .orElse("DEFAULT");

        System.out.println(result);


    }


}
