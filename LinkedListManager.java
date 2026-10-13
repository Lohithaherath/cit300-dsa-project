public class LinkedListManager {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }

    private Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Inserted " + data + " into Linked List.");
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted " + data + " from Linked List.");
            return;
        }
        Node curr = head, prev = null;
        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Element " + data + " not found.");
        } else {
            prev.next = curr.next;
            System.out.println("Deleted " + data + " from Linked List.");
        }
    }

    public void search(int data) {
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Element " + data + " found at node index " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element " + data + " not found in Linked List.");
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        System.out.print("Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}