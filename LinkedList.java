package dsa.program;
public class LinkedList {
    // The head of the list. It's the starting point of the linked list.
    Node head;

    // Inner class representing a single node in the linked list.
    // Each node holds data and a reference to the next node in the sequence.
    class Node {
        int data;     // The data stored in this node.
        Node next;    // A reference (pointer) to the next node in the list.

        // Constructor for the Node class.
        // Initializes a new node with the given value and sets its 'next' pointer to null.
        Node(int val) {
            data = val;
            next = null; // A new node initially points to nothing.
        }
    }

    // Constructor for the LinkedList class.
    // Initializes an empty linked list by setting the head to null.
    LinkedList() {
        head = null; // An empty list has no head node.
    }

    /**
     * Inserts a new node with the given value at the beginning of the linked list.
     * This operation has a time complexity of O(1) (constant time).
     *
     * @param val The integer value to be inserted into the new node.
     */
    public void insertAtBeginning(int val) {
        Node newNode = new Node(val); // Create a new Node with the provided value.

        // Case 1: If the list is currently empty (head is null).
        // The new node becomes the head of the list.
        if (head == null) {
            head = newNode;
        } else {
            // Case 2: If the list is not empty.
            // 1. Make the 'next' pointer of the new node point to the current head.
            //    This effectively links the new node to the rest of the list.
            newNode.next = head;
            // 2. Update the head of the list to be the new node.
            //    The new node is now at the beginning.
            head = newNode;
        }
    }

    /**
     * Displays all the elements (data) in the linked list from head to tail.
     * If the list is empty, it prints a message indicating so.
     * This operation has a time complexity of O(n) (linear time), where n is the number of nodes.
     */
    public void display() {
        Node temp = head; // Start traversal from the head of the list.

        // If the list is empty, print a message.
        if (temp == null) {
            System.out.println("List is empty.");
            return; // Exit the method.
        }

        System.out.print("Linked List: "); // Label for the output.
        // Traverse the list until the end (temp becomes null).
        while (temp != null) {
            System.out.print(temp.data + " "); // Print the data of the current node.
            temp = temp.next; // Move to the next node in the sequence.
        }
        System.out.println(); // Print a newline at the end for clean formatting.
    }
    
   

		
	}


