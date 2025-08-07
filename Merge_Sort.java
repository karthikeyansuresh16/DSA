package dsa.program;

public class Merge_Sort {
	// Main class to demonstrate the Merge Sort algorithm

	    // The main function that sorts array[l..r] using the merge() method
	    public void mergeSort(int[] array, int left, int right) {
	        // Base case: if left is less than right, it means there are at least two elements
	        // and we can split the array further.
	        if (left < right) {
	            // Find the middle point to divide the array into two halves
	            int middle = (left + right) / 2;

	            // Recursively call mergeSort on the first half
	            mergeSort(array, left, middle);

	            // Recursively call mergeSort on the second half
	            mergeSort(array, middle + 1, right);

	            // Once the two halves are sorted, merge them back together
	            merge(array, left, middle, right);
	        }
	    }

	    // This method merges two sorted sub-arrays.
	    // The first sub-array is array[left..middle]
	    // The second sub-array is array[middle+1..right]
	    public void merge(int[] array, int left, int middle, int right) {
	        // Find the sizes of the two sub-arrays
	        int size1 = middle - left + 1;
	        int size2 = right - middle;

	        // Create temporary arrays
	        int[] leftArray = new int[size1];
	        int[] rightArray = new int[size2];

	        // Copy data to the temporary arrays
	        for (int i = 0; i < size1; ++i) {
	            leftArray[i] = array[left + i];
	        }
	        for (int j = 0; j < size2; ++j) {
	            rightArray[j] = array[middle + 1 + j];
	        }

	        // Initial indexes of the first and second sub-arrays
	        int i = 0, j = 0;

	        // Initial index of the merged sub-array
	        int k = left;
	        
	        // Merge the temporary arrays back into the original array
	        while (i < size1 && j < size2) {
	            if (leftArray[i] <= rightArray[j]) {
	                array[k] = leftArray[i];
	                i++;
	            } else {
	                array[k] = rightArray[j];
	                j++;
	            }
	            k++;
	        }

	        // Copy any remaining elements of the left sub-array
	        while (i < size1) {
	            array[k] = leftArray[i];
	            i++;
	            k++;
	        }

	        // Copy any remaining elements of the right sub-array
	        while (j < size2) {
	            array[k] = rightArray[j];
	            j++;
	            k++;
	        }
	    }

	    // A utility function to print the array
	    public static void printArray(int[] array) {
	        int n = array.length;
	        for (int i = 0; i < n; ++i) {
	            System.out.print(array[i] + " ");
	        }
	        System.out.println();
	    }

	    // Main method to test the code
	    public static void main(String[] args) {
	        int[] arr = {12, 11, 13, 5, 6, 7};
	        System.out.println("Given Array:");
	        printArray(arr);

	        Merge_Sort sorter = new Merge_Sort();
	        sorter.mergeSort(arr, 0, arr.length - 1);

	        System.out.println("\nSorted Array:");
	        printArray(arr);
	    }
	}



