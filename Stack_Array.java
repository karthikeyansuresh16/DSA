package dsa.program;

public class Stack_Array {
	static final int MaxValue=20;
	int arr [] =new int[MaxValue];
	int top;
	
	Stack_Array() {
		top=-1;
	}
	
	void push(int val) {
		if(top>MaxValue-1)
			throw new IndexOutOfBoundsException("Stack over flow");
		arr[++top]=val;
	}
	
	int pop() {
		if(top == -1)
			throw new IndexOutOfBoundsException("Stack under flow");
		return(arr[top--]);
	}
	
	int peek() {
		return(arr[top]);
	}
	
	public static void main(String args[]) {
		Stack_Array Stack = new Stack_Array();
		
		Stack.push(33);
		Stack.push(10);
		Stack.push(16);
		//Stack.pop();
		System.out.print(Stack.push());
	}

}
