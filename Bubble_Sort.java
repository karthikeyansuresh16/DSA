package dsa.program;

import java.util.Arrays;

public class Bubble_Sort {
	public static void BubbleSort(int arr[]) {
		int temp=0;
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<arr.length-i;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public static void main(String args[]) {
	int arr[]= {2,10,4,45,67,2};
	Bubble_Sort.BubbleSort(arr);
	System.out.print(Arrays.toString(arr));
	}

}
