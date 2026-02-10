package quicksort;

public class LomutoPartition {
    private LomutoPartition() {}

    public static int partition(int[] a, int low, int high) {
        // if the array is empty or doesn't exist, we can't partition anything so return -1
        if (a == null || a.length == 0) { 
            return -1;
        }

        int pivot = a[high]; // Lomuto pivot rule: pivot is the last element
        int i = low - 1;     // i marks the end of the <= pivot section

        for (int j = low; j <= high - 1; j++) { // j scans every element from low to high - 1 except pivot (a[high] is the pivot)
            if (a[j] <= pivot) {                // if the current element belongs on the left side (<= pivot)
                i++;                            // increment the <= pivot zone (i.e. if i was 2, now it is 3)
                
                // place the element we found (a[j] into the left zone)
                // element j (the one that goes to the left) with element i (the next open spot in the left), if i == j, no change
                swap(a, i, j);                  
            }
        }

        // pivot is at index i+1 right after <= pivot section, we swap the pivot at high with i+1
        // pivot should now be in the middle, and everything to the left and right satisfying the partition rule
        swap(a, i + 1, high); 

        return i + 1; // return pivot's final index
    }

    // swap helper method to swap two elements in the array
    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
