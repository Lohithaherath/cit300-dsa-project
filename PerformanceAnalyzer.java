import java.util.Arrays;

public class PerformanceAnalyzer {

    public static void runComparison(int[] arr, int target, GraphManager graph, int startGraphNode) {
        System.out.println("\n=========================================================");
        System.out.println("               PERFORMANCE COMPARISON                   ");
        System.out.println("=========================================================");
        System.out.printf("%-18s %-15s %-12s %-18s\n", "Operation", "Algorithm", "Steps", "Execution Time");
        System.out.println("---------------------------------------------------------");

        // 1. Linear Search
        int linearSteps = 0;
        long startTime = System.nanoTime();
        for (int value : arr) {
            linearSteps++;
            if (value == target) break;
        }
        long linearTime = System.nanoTime() - startTime;
        System.out.printf("%-18s %-15s %-12d %-18s\n", "Search", "Linear Search", linearSteps, linearTime + " ns");

        // 2. Binary Search
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        int binarySteps = 0;
        int left = 0, right = sortedArr.length - 1;
        startTime = System.nanoTime();
        while (left <= right) {
            binarySteps++;
            int mid = left + (right - left) / 2;
            if (sortedArr[mid] == target) break;
            if (sortedArr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        long binaryTime = System.nanoTime() - startTime;
        System.out.printf("%-18s %-15s %-12d %-18s\n", "Search", "Binary Search", binarySteps, binaryTime + " ns");

        // 3. Graph BFS
        int[] bfsSteps = {0};
        startTime = System.nanoTime();
        String bfsRes = graph.bfs(startGraphNode, bfsSteps);
        long bfsTime = System.nanoTime() - startTime;
        System.out.printf("%-18s %-15s %-12d %-18s\n", "Graph Traversal", "BFS", bfsSteps[0], bfsTime + " ns");

        // 4. Graph DFS
        int[] dfsSteps = {0};
        startTime = System.nanoTime();
        String dfsRes = graph.dfs(startGraphNode, dfsSteps);
        long dfsTime = System.nanoTime() - startTime;
        System.out.printf("%-18s %-15s %-12d %-18s\n", "Graph Traversal", "DFS", dfsSteps[0], dfsTime + " ns");

        System.out.println("---------------------------------------------------------");
        System.out.println("BFS Traversal Result : " + bfsRes);
        System.out.println("DFS Traversal Result : " + dfsRes);
        System.out.println("=========================================================\n");
    }
}