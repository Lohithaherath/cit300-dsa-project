public class QueueManager {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public QueueManager(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int value) {
        if (count == capacity) {
            System.out.println("Queue Overflow Error: Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        count++;
        System.out.println("Enqueued " + value + " to queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow Error: Cannot dequeue from an empty queue.");
            return;
        }
        System.out.println("Dequeued element: " + queue[front]);
        front = (front + 1) % capacity;
        count--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return;
        }
        System.out.println("Front element is: " + queue[front]);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (Front to Rear): [ ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println("]");
    }
}