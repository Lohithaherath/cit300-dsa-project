import java.util.Arrays;

public class SearchManager {

    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search: Found " + target + " at index " + i + " after " + comparisons + " comparisons.");
                return i;
            }
        }
        System.out.println("Linear Search: " + target + " not found after " + comparisons + " comparisons.");
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int comparisons = 0;

        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary Search: Found " + target + " at index " + mid + " after " + comparisons + " comparisons.");
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Binary Search: " + target + " not found after " + comparisons + " comparisons.");
        return -1;
    }

    public static void comparePerformance(int[] dataset, int target) {
        System.out.println("\n--- Searching Performance Comparison ---");
        System.out.println("Dataset Size: " + dataset.length + " elements");

        // Measure Linear Search
        long startTime = System.nanoTime();
        linearSearch(dataset, target);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;

        // Measure Binary Search (Requires Sorted Array)
        int[] sortedDataset = dataset.clone();
        Arrays.sort(sortedDataset);

        startTime = System.nanoTime();
        binarySearch(sortedDataset, target);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;

        System.out.println("\n--- Performance Summary ---");
        System.out.println("Linear Search Execution Time : " + linearTime + " nanoseconds");
        System.out.println("Binary Search Execution Time : " + binaryTime + " nanoseconds (Array Sorted)");
    }
}