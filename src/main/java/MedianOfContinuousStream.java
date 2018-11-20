import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by sumit.jha on 17/06/18.
 */
public class MedianOfContinuousStream {

    private static PriorityQueue<Integer> lower = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -1 * o1.compareTo(o2);

        }
    });
    private static PriorityQueue<Integer> higher = new PriorityQueue<>();

    static void addToHeap(int val) {
        if (lower.size() == 0 || val < lower.peek()) {
            lower.add(val);
        } else {
            higher.add(val);
        }
    }

    static void balanceHeaps() {
        if (Math.abs(lower.size() - higher.size()) > 1) {
            if (lower.size() > higher.size()) {
                higher.add(lower.poll());
            } else {
                lower.add(higher.poll());
            }
        }
    }

    static double getMedian() {
        if (lower.size() > higher.size()) {
            return lower.peek();
        } else if (lower.size() < higher.size()) {
            return higher.peek();
        }
        return ((double) lower.peek() + (double) higher.peek()) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};

        for (int i = 0; i < arr.length; i++) {
            addToHeap(arr[i]);
            balanceHeaps();
            System.out.println(getMedian());
        }
    }
}
