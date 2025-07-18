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
    
    public void deleteAtPos(int pos) {
    	if(head== null) {
    		throw new IllegalArgumentException("List is empty. Cannot delete.");
    	}
    	if(pos == 0) {
    		head=head.next;
    	    return;
    	}    
    	else {
    	Node temp= head;
    	Node prev = null;
    	
    	for(int i=1;i<pos;i++) {
    		prev = temp;
    		temp = temp.next;
    	}
    	
    	prev.next=temp.next;
    	
    }
    }
    
    public void getIndex(int index) {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty. Cannot get element.");
            return;
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative.");
        }

        // Traverse to the desired index
        for (int i = 0; i < index; i++) {
            if (temp == null) { // If temp becomes null before reaching the index, it's out of bounds
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
            }
            temp = temp.next; // Move to the next node
        }

        // After the loop, 'temp' should be the node at the desired index.
        // If temp is null here, it means the index was out of bounds (e.g., index was too large).
        if (temp == null) {
             throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }

        System.out.println("Data at index " + index + ": " + temp.data);
    }
    
    
    
    
    public void updateAtPos(int pos, int newValue) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty. Cannot update.");
        }
        if (pos < 0) {
            throw new IllegalArgumentException("Position cannot be negative.");
        }

        Node temp = head;
        // Traverse to the desired position
        for (int i = 0; i < pos; i++) {
            if (temp == null) { // If temp becomes null before reaching the position, it's out of bounds
                throw new IndexOutOfBoundsException("Position " + pos + " is out of bounds.");
            }
            temp = temp.next; // Move to the next node
        }

        // After the loop, 'temp' should be the node at the desired position.
        // If temp is null here, it means the position was out of bounds.
        if (temp == null) {
            throw new IndexOutOfBoundsException("Position " + pos + " is out of bounds.");
        }

        // Update the data of the node
        temp.data = newValue;
        System.out.println("Node at position " + pos + " updated to: " + newValue);
    }
    
    
    public void insertAtPos(int pos, int val) {
        if (pos < 0) {
            throw new IllegalArgumentException("Position cannot be negative.");
        }

        Node newNode = new Node(val);

        // Case 1: Insert at the beginning (pos = 0)
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            System.out.println("Node " + val + " inserted at position " + pos);
            return;
        }

        // Case 2: Insert in the middle or at the end
        Node temp = head;
        Node prev = null;
        int currentPos = 0;

        // Traverse to the node just before the desired position
        // We need to stop at 'pos - 1' to update its 'next' pointer
        while (temp != null && currentPos < pos) {
            prev = temp;
            temp = temp.next;
            currentPos++;
        }

        // If currentPos is less than pos, it means we reached the end of the list
        // before the desired position, indicating an out-of-bounds insertion.
        // This handles cases like trying to insert at pos 5 in a list with only 2 elements (max valid pos for appending is 2).
        if (currentPos < pos) {
            throw new IndexOutOfBoundsException("Position " + pos + " is out of bounds for insertion.");
        }

        // Link the new node
        newNode.next = temp; // New node points to the node currently at 'pos' (or null if inserting at end)
        if (prev != null) {
            prev.next = newNode; // Previous node points to the new node
        } else {
            // This case should ideally not be reached if pos == 0 is handled above,
            // but it's a safeguard if the head was null and pos was 0 (though handled above).
            // If prev is null here, it implies temp is also head, which means pos was 0.
            // However, the pos == 0 case is explicitly handled.
            // This 'else' block could be removed if we are absolutely sure prev will not be null here.
            // For robustness, keeping it for now, though it's redundant with the pos == 0 check.
            head = newNode;
        }
        System.out.println("Node " + val + " inserted at position " + pos);
    }

    	
    	
    		
    		
    		
   
    }
    
   

		



