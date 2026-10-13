import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayManager arrayMgr = new ArrayManager(10);
        StackManager stackMgr = new StackManager(5);
        QueueManager queueMgr = new QueueManager(5);
        LinkedListManager listMgr = new LinkedListManager();
        GraphManager graphMgr = new GraphManager();

        // Sample Graph Data
        graphMgr.addEdge(1, 2);
        graphMgr.addEdge(1, 3);
        graphMgr.addEdge(2, 4);

        boolean exit = false;
        while (!exit) {
            System.out.println("==================================================");
            System.out.println("          DATA STRUCTURE & GRAPH ANALYZER         ");
            System.out.println("==================================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1: handleArray(arrayMgr); break;
                case 2: handleStack(stackMgr); break;
                case 3: handleQueue(queueMgr); break;
                case 4: handleLinkedList(listMgr); break;
                case 5: handleSearching(arrayMgr); break;
                case 6: handleGraph(graphMgr); break;
                case 7: 
                    System.out.print("Enter search target value for benchmark: ");
                    int target = getIntInput();
                    PerformanceAnalyzer.runComparison(arrayMgr.getRawArray(), target, graphMgr, 1);
                    break;
                case 8:
                    System.out.println("\n--- ALL STRUCTURES DISPLAY ---");
                    arrayMgr.display();
                    stackMgr.display();
                    queueMgr.display();
                    listMgr.display();
                    graphMgr.displayGraph();
                    break;
                case 9:
                    System.out.println("Exiting System. Good Luck!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void handleArray(ArrayManager mgr) {
        System.out.println("\n--- ARRAY OPERATIONS ---");
        System.out.println("1. Insert | 2. Delete | 3. Search | 4. Display | 5. Back");
        int c = getIntInput();
        if (c == 1) { System.out.print("Val: "); mgr.insert(getIntInput()); }
        else if (c == 2) { System.out.print("Val: "); mgr.delete(getIntInput()); }
        else if (c == 3) { System.out.print("Val: "); mgr.search(getIntInput()); }
        else if (c == 4) mgr.display();
    }

    private static void handleStack(StackManager mgr) {
        System.out.println("\n--- STACK OPERATIONS ---");
        System.out.println("1. Push | 2. Pop | 3. Peek | 4. Display | 5. Back");
        int c = getIntInput();
        if (c == 1) { System.out.print("Val: "); mgr.push(getIntInput()); }
        else if (c == 2) mgr.pop();
        else if (c == 3) mgr.peek();
        else if (c == 4) mgr.display();
    }

    private static void handleQueue(QueueManager mgr) {
        System.out.println("\n--- QUEUE OPERATIONS ---");
        System.out.println("1. Enqueue | 2. Dequeue | 3. Peek | 4. Display | 5. Back");
        int c = getIntInput();
        if (c == 1) { System.out.print("Val: "); mgr.enqueue(getIntInput()); }
        else if (c == 2) mgr.dequeue();
        else if (c == 3) mgr.peek();
        else if (c == 4) mgr.display();
    }

    private static void handleLinkedList(LinkedListManager mgr) {
        System.out.println("\n--- LINKED LIST OPERATIONS ---");
        System.out.println("1. Insert | 2. Delete | 3. Search | 4. Display | 5. Back");
        int c = getIntInput();
        if (c == 1) { System.out.print("Val: "); mgr.insert(getIntInput()); }
        else if (c == 2) { System.out.print("Val: "); mgr.delete(getIntInput()); }
        else if (c == 3) { System.out.print("Val: "); mgr.search(getIntInput()); }
        else if (c == 4) mgr.display();
    }

    private static void handleSearching(ArrayManager mgr) {
        System.out.print("Enter target to search in current Array: ");
        int target = getIntInput();
        mgr.search(target);
    }

    private static void handleGraph(GraphManager mgr) {
        System.out.println("\n--- GRAPH OPERATIONS ---");
        System.out.println("1. Add Vertex | 2. Add Edge | 3. Display Graph | 4. BFS Traversal | 5. DFS Traversal | 6. Back");
        int c = getIntInput();
        if (c == 1) { System.out.print("Vertex ID: "); mgr.addVertex(getIntInput()); }
        else if (c == 2) { System.out.print("Src: "); int u = getIntInput(); System.out.print("Dest: "); mgr.addEdge(u, getIntInput()); }
        else if (c == 3) mgr.displayGraph();
        else if (c == 4) { System.out.print("Start: "); System.out.println("BFS: " + mgr.bfs(getIntInput(), new int[]{0})); }
        else if (c == 5) { System.out.print("Start: "); System.out.println("DFS: " + mgr.dfs(getIntInput(), new int[]{0})); }
    }
}