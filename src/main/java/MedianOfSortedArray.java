import java.util.Map;

/**
 * Created by sumit.jha on 18/06/18.
 */
public class MedianOfSortedArray {

    private static double findMedian(int[] arr1, int[] arr2) {

        if (arr1.length > arr2.length) {
            return findMedian(arr2, arr1);
        }
        int start = 0;
        int end = arr1.length;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int partitionX = mid;
            int partitionY = ((arr1.length + arr2.length + 1) >> 1) - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY - 1];

            int minRightX = partitionX == arr1.length ? Integer.MAX_VALUE : arr1[partitionX];
            int minRightY = partitionY == arr2.length ? Integer.MAX_VALUE : arr2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((arr1.length + arr2.length) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                } else {
                    return ((double) Math.max(maxLeftX, maxLeftY) + (double) Math.min(minRightX, minRightY)) / 2;
                }
            } else if (maxLeftX > minRightY) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        throw new IllegalArgumentException("Input array is not sorted");
    }

    public static void main(String[] args) {
        int[] arr1 = { -43, -25, -18, -15, -10, 9, 39, 40};
        int[] arr2 = {-2};
        System.out.println(findMedian(arr1, arr2));
    }


}
