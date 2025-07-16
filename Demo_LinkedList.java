package dsa.program;

public class Demo_LinkedList {
	public static void main(String[] args) {
		LinkedList list  = new LinkedList();
		
		System.out.println("--- Testing insertAtBeginning and display ---");

        // Test with an empty list initially
        list.display(); // Expected: List is empty.

        // Insert some elements
        list.insertAtBeginning(10); // List: 10
        list.display();

        list.insertAtBeginning(20); // List: 20 -> 10
        list.display();

        list.insertAtBeginning(30); // List: 30 -> 20 -> 10
        list.display();

        list.insertAtBeginning(5);  // List: 5 -> 30 -> 20 -> 10
        list.display();

		
	}

}
