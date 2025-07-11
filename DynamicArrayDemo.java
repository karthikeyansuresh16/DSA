package sample;

import java.util.*;
class DynamicArray{
    private static final int initialCapacity =16;
    private int arr[];
    private int size;
    private int capacity;
    
    DynamicArray(){
    	size = 0;
    	arr = new int[initialCapacity];
    	capacity= initialCapacity;
    }
    public void add(int val) {
    	if(size==capacity)
    		expandArray();
    	arr[size++]=val;
    }
    
    private void expandArray() {
    	capacity *=2;
    	arr = java.util.Arrays.copyOf(arr,capacity);
    }
    private void shrinkArray() {
    	capacity =capacity/3;
    	arr = java.util.Arrays.copyOf(arr,capacity);
    }
    
    public void display() {
    	for(int i=0;i<size;i++)
    		System.out.print(arr[i]+" ");
    }	
    
    public void addAtPos(int pos,int val) {
    	if(size==capacity)
    		expandArray();
    	for(int i=size-1;i<pos;i--) {
    		arr[i+1]=arr[i];
    	}
    	arr[pos]=val;
    	size++;
    }
    
    public void DelAtPos(int pos) {
    	for(int i=pos+1;i<size-1;i++) 
    		arr[i-1]=arr[i];
    	size--;
    	if(capacity < initialCapacity && capacity < 3*size) {
    		shrinkArray();
    	}
    }	
    	
    
    
    	
     
}
        

public class DynamicArrayDemo {
    DynamicArray list= new DynamicArray();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int val,pos;
        while(true){
            System.out.println("---------new List---------");
            System.out.println("1.Insert at the End");
            System.out.println("2.Display the List");
            System.out.println("3.Insert at the specified position");
            System.out.println("4.Delete at the specified position");
            System.out.println("5.Exit");
            System.out.println("--------------------");
            System.out.println("Enter your Choice");
            int choice=sc.nextInt();
            switch(choice){
                case 1:System.out.println("Enter the data");
                    val=sc.nextInt();
                    list.add(val);
                    break;
                case 2:
                    list.display();
                    break; 
                case 3:System.out.print("Enter the spicific position  (position starts at 0)");
                    pos=sc.nextInt();
                    if(pos<0){
                        System.out.print("Enter the valid number");
                        break;
                    }    
                    else{
                        System.out.print("Enter the value");
                        val=sc.nextInt();
                        list.InsertAtPosition(pos,val);
                        break;
                    }
                case 4:System.out.print("Enter the position to be delete");
                    pos=sc.nextInt();
                    list.delAtPos(pos);
                    break;

                    

                 
            }
        }
    }

    
}}
