public class StackManager {
    private int[] stack;
    private int top;
    private int capacity;

    public StackManager(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow Error: Cannot push " + value);
            return;
        }
        stack[++top] = value;
        System.out.println("Pushed " + value + " to Stack.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow Error: Cannot pop from empty stack.");
            return;
        }
        System.out.println("Popped element: " + stack[top--]);
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top element: " + stack[top]);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (Top to Bottom): [ ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("]");
    }
}