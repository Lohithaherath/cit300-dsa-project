import java.util.*;

public class GraphManager {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addVertex(int vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new LinkedList<>());
            System.out.println("Added Vertex: " + vertex);
        } else {
            System.out.println("Vertex " + vertex + " already exists.");
        }
    }

    public void addEdge(int u, int v) {
        addVertex(u);
        addVertex(v);
        adjList.get(u).add(v);
        adjList.get(v).add(u);
        System.out.println("Added Edge between " + u + " and " + v);
    }

    public void displayGraph() {
        if (adjList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("\n--- Adjacency List ---");
        for (var entry : adjList.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public String bfs(int startVertex, int[] stepCounter) {
        if (!adjList.containsKey(startVertex)) return "Invalid Start Vertex";
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            stepCounter[0]++;
            result.append(current).append(" ");

            for (int neighbor : adjList.get(current)) {
                stepCounter[0]++;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return result.toString();
    }

    public String dfs(int startVertex, int[] stepCounter) {
        if (!adjList.containsKey(startVertex)) return "Invalid Start Vertex";
        Set<Integer> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();
        dfsHelper(startVertex, visited, result, stepCounter);
        return result.toString();
    }

    private void dfsHelper(int vertex, Set<Integer> visited, StringBuilder result, int[] stepCounter) {
        visited.add(vertex);
        stepCounter[0]++;
        result.append(vertex).append(" ");

        for (int neighbor : adjList.get(vertex)) {
            stepCounter[0]++;
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, result, stepCounter);
            }
        }
    }
}