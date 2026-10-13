import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  CIT300 Data Structures & Graph Performance Analyzer");
        System.out.println("==================================================");

        ArrayManager arrayMgr = new ArrayManager(10);
        LinkedListManager listMgr = new LinkedListManager();
        StackManager stackMgr = new StackManager(5);
        QueueManager queueMgr = new QueueManager(5);
        GraphManager graphMgr = new GraphManager();

        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Performance Comparison");
            System.out.println("6. Graph Operations (BFS / DFS)");
            System.out.println("7. Exit System");
            System.out.print("Select an option (1-7): ");

            int choice = getValidIntInput();

            switch (choice) {
                case 1:
                    handleArrayMenu(arrayMgr);
                    break;
                case 2:
                    handleStackMenu(stackMgr);
                    break;
                case 3:
                    handleQueueMenu(queueMgr);
                    break;
                case 4:
                    handleLinkedListMenu(listMgr);
                    break;
                case 5:
                    handleSearchMenu();
                    break;
                case 6:
                    handleGraphMenu(graphMgr);
                    break;
                case 7:
                    System.out.println("Exiting System. Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 7.");
            }
        }
        scanner.close();
    }

    private static int getValidIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void handleArrayMenu(ArrayManager mgr) {
        System.out.println("\n--- Array Operations ---");
        System.out.println("1. Insert | 2. Delete | 3. Search | 4. Display");
        System.out.print("Choice: ");
        int choice = getValidIntInput();
        if (choice == 1) {
            System.out.print("Enter integer to insert: ");
            mgr.insert(getValidIntInput());
        } else if (choice == 2) {
            System.out.print("Enter integer to delete: ");
            mgr.delete(getValidIntInput());
        } else if (choice == 3) {
            System.out.print("Enter integer to search: ");
            mgr.search(getValidIntInput());
        } else if (choice == 4) {
            mgr.display();
        }
    }

    private static void handleStackMenu(StackManager mgr) {
        System.out.println("\n--- Stack Operations ---");
        System.out.println("1. Push | 2. Pop | 3. Peek | 4. Display");
        System.out.print("Choice: ");
        int choice = getValidIntInput();
        if (choice == 1) {
            System.out.print("Enter integer to push: ");
            mgr.push(getValidIntInput());
        } else if (choice == 2) {
            mgr.pop();
        } else if (choice == 3) {
            mgr.peek();
        } else if (choice == 4) {
            mgr.display();
        }
    }

    private static void handleQueueMenu(QueueManager mgr) {
        System.out.println("\n--- Queue Operations ---");
        System.out.println("1. Enqueue | 2. Dequeue | 3. Peek | 4. Display");
        System.out.print("Choice: ");
        int choice = getValidIntInput();
        if (choice == 1) {
            System.out.print("Enter integer to enqueue: ");
            mgr.enqueue(getValidIntInput());
        } else if (choice == 2) {
            mgr.dequeue();
        } else if (choice == 3) {
            mgr.peek();
        } else if (choice == 4) {
            mgr.display();
        }
    }

    private static void handleLinkedListMenu(LinkedListManager mgr) {
        System.out.println("\n--- Linked List Operations ---");
        System.out.println("1. Insert | 2. Delete | 3. Search | 4. Display");
        System.out.print("Choice: ");
        int choice = getValidIntInput();
        if (choice == 1) {
            System.out.print("Enter integer to insert: ");
            mgr.insert(getValidIntInput());
        } else if (choice == 2) {
            System.out.print("Enter integer to delete: ");
            mgr.delete(getValidIntInput());
        } else if (choice == 3) {
            System.out.print("Enter integer to search: ");
            mgr.search(getValidIntInput());
        } else if (choice == 4) {
            mgr.display();
        }
    }

    private static void handleSearchMenu() {
        System.out.print("Enter size of dataset to benchmark (e.g., 1000): ");
        int size = getValidIntInput();
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = (int) (Math.random() * 10000);
        }
        System.out.print("Enter target value to search: ");
        int target = getValidIntInput();
        SearchManager.comparePerformance(dataset, target);
    }

    private static void handleGraphMenu(GraphManager mgr) {
        System.out.println("\n--- Graph Operations ---");
        System.out.println("1. Add Vertex | 2. Add Edge | 3. Display Graph | 4. BFS Traversal | 5. DFS Traversal");
        System.out.print("Choice: ");
        int choice = getValidIntInput();
        if (choice == 1) {
            System.out.print("Enter vertex ID: ");
            mgr.addVertex(getValidIntInput());
        } else if (choice == 2) {
            System.out.print("Enter Source Vertex ID: ");
            int u = getValidIntInput();
            System.out.print("Enter Destination Vertex ID: ");
            int v = getValidIntInput();
            mgr.addEdge(u, v);
        } else if (choice == 3) {
            mgr.displayGraph();
        } else if (choice == 4) {
            System.out.print("Enter start vertex for BFS: ");
            mgr.bfs(getValidIntInput());
        } else if (choice == 5) {
            System.out.print("Enter start vertex for DFS: ");
            mgr.dfs(getValidIntInput());
        }
    }
}