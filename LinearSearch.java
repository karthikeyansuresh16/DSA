package dsa.program;

import java.util.Arrays;

public class LinearSearch {
	public static int find(int arr [], int target) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target)
				return i;
		}
		return -1;
	}
	
	public static boolean contains(int arr[],int target) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target)
				return true;
		}
		return false;
	}
	
	
// Linear Search for Strings
	
	public static int findString(String s, char ch) {
		char c[]=s.toCharArray();
		for(int i=0;i<c.length-1;i++) {
			if(c[i]==ch)
				return i;
		}
		return -1;
	}
	
	
// Linear Search for 2D array 
	
	public static int[] find(int arr[][], int target) {
		for(int row=0;row<arr.length;row++) {
			for(int col=0;col<arr[row].length;col++) {
				if(arr[row][col]== target)
					return new int[] {row,col};
			}
		}
		return null;
		
	}
	
	public static void main(String args[]) {
//		int []arr = {10,20,30,40,50,60,70,45};
//		System.out.print(LinearSearch.contains(arr,7));
//		
		//String s="Swetha";
		//System.out.print(LinearSearch.findString(s, 'w'));
		
		int arr[][] = new int[][] {
			{23,2,3,45},
			{10,34,2,9},
			{12}
		};
		int result[]=LinearSearch.find(arr,2);
		System.out.print(Arrays.toString(result));
		
	}

}
