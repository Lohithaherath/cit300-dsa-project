import java.util.Arrays;

public class SearchManager {

    // Linear Search with step counting
    public static int linearSearch(int[] arr, int target, int[] stepCounter) {
        for (int i = 0; i < arr.length; i++) {
            stepCounter[0]++;
            if (arr[i] == target) {
                return i; // Found index
            }
        }
        return -1; // Not found
    }

    // Binary Search with step counting (Array must be sorted)
    public static int binarySearch(int[] arr, int target, int[] stepCounter) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            stepCounter[0]++;
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Found index
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }
}