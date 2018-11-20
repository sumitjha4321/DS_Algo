
/**
 * Created by sumit.jha on 18/06/18.
 */
public class MergeSort {

    private static int ans = 0;
    private static int mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            ans += merge(arr, start, mid, end);
        }
        return ans;
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int ans = 0;

        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                ans += (n1 - i);
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int ans = mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        System.out.println(ans);
    }
}
