package ds.lambdas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sumit.jha on 04/08/18.
 */
public class InterfacePlaying {

    static class Animal {

    }


    interface Valid<T extends Number> {
        boolean test(T value);
    }

    private static class Temp<E extends List, T extends Number> implements Valid<T>{

        private E value;

        @Override
        public boolean test(T value) {
            return false;
        }
    }

    private static class ValidImpl<T extends Number> implements Valid<T> {

        T t;

        @Override
        public boolean test(T value) {
            return false;
        }

        public <U extends Number> boolean check(U u) {
            return u.equals(t);

        }
    }


    public static void main(String[] args) {

    }

}
