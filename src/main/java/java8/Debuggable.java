package java8;

import sun.jvm.hotspot.debugger.Debugger;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class Debuggable {
    static interface Calculator<T> {
        T operate(T first, T second, BiFunction<T, T, T> function);
    }

    private static class BasicCalculator<T> implements Calculator<T> {

        @Override
        public T operate(T first, T second, BiFunction<T, T, T> function) {
            return function.apply(first, second);
        }
    }

    private static int a;

    public static void main(String[] args) {
        Calculator<Integer> additionCalculator = new BasicCalculator<>();
        System.out.println(additionCalculator.operate(a, 20, (a, b) -> a + b));


        Calculator<Double> divisionCalculator = new BasicCalculator<>();
        System.out.println(divisionCalculator.operate(20D, 11D, (a, b) -> a / b));


    }
}
