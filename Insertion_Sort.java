package dsa.program;

import java.util.Arrays;

public class Insertion_Sort {
	public static void InsertionSorting(int arr[]) {
		int temp =0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}	
				else {
					break;
				}
				
			}
		}
	}
	public static void main(String args[]) {
		int arr[]= {5,8,2,9,10};
		Insertion_Sort.InsertionSorting(arr);
		System.out.print(Arrays.toString(arr));
	}

}
