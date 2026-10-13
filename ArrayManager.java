public class ArrayManager {
    private int[] array;
    private int size;
    private int capacity;

    public ArrayManager(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Error: Array is full! Cannot insert " + value);
            return;
        }
        array[size++] = value;
        System.out.println("Successfully inserted: " + value);
    }

    public void delete(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Element " + value + " not found in array.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        System.out.println("Successfully deleted: " + value);
    }

    public void search(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                System.out.println("Element " + value + " found at index " + i);
                return;
            }
        }
        System.out.println("Element " + value + " not found in array.");
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array Elements: [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }
}