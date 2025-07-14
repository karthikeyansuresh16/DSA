package sample;

import java.util.*;

class DynamicArray {
    private static final int initialCapacity = 16;
    private int arr[];
    private int size;
    private int capacity;

    DynamicArray() {
        size = 0;
        arr = new int[initialCapacity];
        capacity = initialCapacity;
    }

    public void add(int val) {
        if (size == capacity)
            expandArray();
        arr[size++] = val;
    }

    private void expandArray() {
        capacity *= 2;
        arr = java.util.Arrays.copyOf(arr, capacity);
    }

    // A more robust shrinkArray strategy
    private void shrinkArray() {
        // Shrink if size is less than 1/4th of capacity and capacity is greater than initialCapacity
        if (size < capacity / 4 && capacity > initialCapacity) {
            capacity /= 2; // Halve the capacity
            arr = java.util.Arrays.copyOf(arr, capacity);
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("List is empty.");
            return;
        }
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println(); // Add a new line for better formatting
    }

    public void addAtPos(int pos, int val) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position for insertion.");
            return;
        }

        if (size == capacity) {
            expandArray();
        }

        // Shift elements to the right to make space for the new element
        for (int i = size - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = val;
        size++;
    }

    public void DelAtPos(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position for deletion.");
            return;
        }

        // Shift elements to the left to fill the gap
        for (int i = pos + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;

        // Consider shrinking if the array is sparsely populated
        shrinkArray();
    }
}

public class DynamicArrayDemo {
    // Make list static so it can be accessed from the static main method
    static DynamicArray list = new DynamicArray();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int val, pos;
        while (true) {
            System.out.println("---------New List---------");
            System.out.println("1. Insert at the End");
            System.out.println("2. Display the List");
            System.out.println("3. Insert at the specified position");
            System.out.println("4. Delete at the specified position");
            System.out.println("5. Exit");
            System.out.println("--------------------------");
            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the data: ");
                    val = sc.nextInt();
                    list.add(val);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter the specific position (position starts at 0): ");
                    pos = sc.nextInt();
                    // No need for if(pos<0) here, as addAtPos handles it.
                    System.out.print("Enter the value: ");
                    val = sc.nextInt();
                    list.addAtPos(pos, val); // Corrected method name
                    break;
                case 4:
                    System.out.print("Enter the position to be deleted: ");
                    pos = sc.nextInt();
                    list.DelAtPos(pos);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}