package dsa.program;
public class Quick_Sort {

    // The main method to start the sorting process.
    // It calls the recursive quick sort helper function.
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // This is the recursive helper function for quick sort.
    private void quickSort(int[] arr, int low, int high) {
        // Base case: if the low index is less than the high index,
        // it means there's more than one element to sort.
        if (low < high) {
            // Partition the array and get the pivot index.
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the sub-array before the pivot.
            quickSort(arr, low, pivotIndex - 1);

            // Recursively sort the sub-array after the pivot.
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // This method partitions the array around a pivot element.
    // It places the pivot in its correct sorted position and
    // moves all smaller elements to its left and larger elements to its right.
    private int partition(int[] arr, int low, int high) {
        // We choose the last element as the pivot.
        int pivot = arr[high];
        // The index of the smaller element, which indicates the correct position of the pivot.
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                // Increment the index of the smaller element
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }
        // Swap the pivot element with the element at the correct position (i + 1)
        swap(arr, i + 1, high);

        // Return the final position of the pivot.
        return i + 1;
    }

    // A utility function to swap two elements in an array.
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // The main method to test the QuickSort implementation.
    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("Unsorted Array:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();

        Quick_Sort qs = new Quick_Sort();
        qs.sort(data);

        System.out.println("Sorted Array:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
