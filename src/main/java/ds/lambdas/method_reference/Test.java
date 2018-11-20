package ds.lambdas.method_reference;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {
    static interface Sayable {
        void say();
    }

    public static void saySomething() {
        System.out.println("Hi there");
    }

    static class Arithmetic {
        public static int add(int a, int b) {
            return a + b;
        }

        public static float add(int a, float b) {
            return a + b;
        }

        public static float add(float a, float b) {
            return a + b;
        }
    }

    public float divide(int a, int b) {
        return a / 2;
    }

    interface Dividable {
        float divide(int a, int b);
    }

    public static <T> void print(T val) {
        System.out.println(val);
    }

    public static void main(String[] args) {

        Sayable sayable = new Sayable() {
            @Override
            public void say() {
                saySomething();
            }
        };

        Sayable lambaSayable = () -> saySomething();

        Sayable methodReferenceSayable = Test::saySomething;

        BiFunction<Integer, Integer, Integer> function = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer first, Integer second) {
                return Arithmetic.add(first, second);
            }
        };

        BiFunction<Integer, Integer, Integer> lambdaFunction = (first, second) -> Arithmetic.add(first, second);

        BiFunction<Integer, Integer, Integer> methodReferenceFunction = Arithmetic::add;


        System.out.println(methodReferenceFunction.apply(1, 2));

        Dividable lambdaDividable = (a, b) -> new Test().divide(a, b);

        Dividable methodReferenceDividable = new Test()::divide;

        List<Integer> list = Arrays.asList(1, 2, 3, 4);


        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                print(integer);
            }
        });

        list.forEach(val -> print(val));

        list.forEach(Test::print);
        list.stream()
                .filter(p->true)
                .collect(Collectors.toList());



    }

}
