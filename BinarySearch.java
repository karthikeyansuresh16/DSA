package dsa.program;

public class BinarySearch {
	public static int search(int arr[],int target) {
		int start=0,end=arr.length-1; 
		
		if(arr[start] < arr[end]) {
		while(start<=end) { // for array sorted in ascending order
			int mid=(start+end)/2;
			if(target>arr[mid]) {  // focus on right side
				start=mid+1;
			}
			else if(target<arr[mid]) {  // focus on left side
				end=mid-1;
			}
			else if(target==arr[mid])
				return mid;
			
		}
		
		}
		else if(arr[start] > arr[end]) {  // for array sorted in descending order
			while(start<=end) {
				int mid=(start+end)/2;
				if(target<arr[mid]) {  // focus on left side
					start=mid+1;
				}
				else if(target>arr[mid]) {  // focus on right side
					end=mid-1;
				}
				else if(target==arr[mid])
					return mid;
				
			}
			
			
		}
		return -1;
		
	}
	
	public static void main(String args[]) {
		int arr[]= {12,23,45,67,89,90,99};
		
		int result = BinarySearch.search(arr,67);
		System.out.println(result);
		
		int dec[]= {99,87,76,65,54,43,33,21,11};
		System.out.println(BinarySearch.search(dec,33));
	}

}
