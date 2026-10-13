import java.util.*;

public class GraphManager {
    private Map<Integer, List<Integer>> adjList;

    public GraphManager() {
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (adjList.containsKey(vertex)) {
            System.out.println("Vertex " + vertex + " already exists.");
            return;
        }
        adjList.put(vertex, new LinkedList<>());
        System.out.println("Added vertex: " + vertex);
    }

    public void addEdge(int source, int destination) {
        if (!adjList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjList.containsKey(destination)) {
            addVertex(destination);
        }
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // Undirected Graph
        System.out.println("Added edge between " + source + " and " + destination);
    }

    public void displayGraph() {
        if (adjList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("\n--- Graph Representation (Adjacency List) ---");
        for (var entry : adjList.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void bfs(int startVertex) {
        if (!adjList.containsKey(startVertex)) {
            System.out.println("Start vertex " + startVertex + " does not exist.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        System.out.print("BFS Traversal starting from vertex " + startVertex + ": ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startVertex) {
        if (!adjList.containsKey(startVertex)) {
            System.out.println("Start vertex " + startVertex + " does not exist.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Traversal starting from vertex " + startVertex + ": ");
        dfsHelper(startVertex, visited);
        System.out.println();
    }

    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}