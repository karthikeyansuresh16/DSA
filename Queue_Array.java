package dsa.program;

public class Queue_Array {
	static final int MaxSize =30;
	int arr[];
	int front,rear;
	
	
	Queue_Array(){
		arr=new int[MaxSize];
		front =-1;
		rear =-1;
	}
	
	void enQueue(int val) {
		if(rear>MaxSize-1) {
			throw new IndexOutOfBoundsException("Array over flow");
		}
		if(front==-1)
			front=0;
		arr[++rear] = val;
	}
	
	public int deQueue() {
		if(rear ==-1 || front > rear) {
			throw new IndexOutOfBoundsException("Array under flow");
		}
		return(arr[front++]);
		
	}
	
	public static void main(String args[]) {
		Queue_Array s=new Queue_Array();
		s.enQueue(30);
		s.enQueue(23);
		s.enQueue(20);
		System.out.print("Enqueue"+ s.deQueue());
	}

}
