package prep;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sumit.jha on 08/10/18.
 */
public class MedianOfSortedArray2 {

    private double getMedian(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return getMedian(arr2, arr1);
        }
        int start = 0;
        int end = arr1.length;

        while (true) {
            int px = (start + end) / 2;
            int py = (arr1.length + arr2.length + 1) / 2 - px;

            int maxX = (px - 1) >= 0 ? arr1[px - 1] : Integer.MIN_VALUE;
            int maxY = (py - 1) >= 0 ? arr2[py - 1] : Integer.MIN_VALUE;

            int minX = px != arr1.length ? arr1[px] : Integer.MAX_VALUE;
            int minY = py != arr2.length ? arr2[py] : Integer.MAX_VALUE;

            if (maxX <= minY && maxY <= minX) {
                if ((arr1.length + arr2.length) % 2 == 0) {
                    return (1D * Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                end = px - 1;
            } else {
                start = px + 1;
            }
        }
    }
    public static double findMedianSortedArrays(final List<Integer> arr1, final List<Integer> arr2) {


        if (arr1.size() > arr2.size()) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int start = 0;
        int end = arr1.size();

        while (true) {
            int px = (start + end) / 2;
            int py = (arr1.size() + arr2.size() + 1) / 2 - px;

            int maxX = (px - 1) >= 0 ? arr1.get(px - 1) : Integer.MIN_VALUE;
            int maxY = (py - 1) >= 0 ? arr2.get(py - 1) : Integer.MIN_VALUE;

            int minX = px != arr1.size() ? arr1.get(px) : Integer.MAX_VALUE;
            int minY = py != arr2.size() ? arr2.get(py) : Integer.MAX_VALUE;

            if (maxX <= minY && maxY <= minX) {
                if ((arr1.size() + arr2.size()) % 2 == 0) {
                    return (1D * Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                end = px - 1;
            } else {
                start = px + 1;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40), Arrays.asList(-2)));

    }
}
