import java.util.*;
import java.util.function.Function;

public class api_with_java8 {

    public static void main(String[] args) {

    List<String> arrayList = Arrays.asList("JAVA", "C", "JAVA", "PYTHON");

    Map<String, Integer> map = new HashMap<>();
    for (String s : arrayList) {
        Integer count = map.computeIfAbsent(s, key -> 0);
        map.put(s, count + 1);
    }

    for (String s : arrayList){
        System.out.println(s +" -> " + map.get(s));

    }

    }
}
