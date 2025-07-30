package dsa.program;

import java.util.Arrays;

public class Selection_Sort {
	public static void SelectionSort(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			int min=arr[i];
			int minIndex=i;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]<min) {
					min=arr[j];
					minIndex=j;
				}
			}	
					int temp=arr[i];
					arr[i]=min;
					arr[minIndex]=temp;
		}
			
		
	}
	public static void main(String args[]) {
		int arr[]= {10,5,26,3,15,22};
		Selection_Sort.SelectionSort(arr);
		System.out.print(Arrays.toString(arr));
	}

}
