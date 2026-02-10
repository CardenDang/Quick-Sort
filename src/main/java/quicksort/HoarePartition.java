package quicksort;

public class HoarePartition {
    private HoarePartition() {}

    /**
     * Hoare partition: pivot = a[low].
     * Returns a split index p.
     */
    public static int partition(int[] a, int low, int high) {
        // if the array is empty or doesn't exist, we can't partition anything so return -1
        if (a == null || a.length == 0) {
            return -1;
        }
        
        int pivot = a[low]; // Hoare picks pivot as the first element of the range
        int i = low - 1;    // i starts just before the left side and moves right until it finds an element that belongs on the right side
        int j = high + 1;   // j starts just after the right side and moves left until it finds an element that belongs on the left side

        while (true) { 
            do { 
                i++; // move i one step to the right
            } while (a[i] < pivot); // keep moving while the element < pivot, i stops at the first position >= pivot where it's too big to stay on the left

            do { 
                j--; // move j one step to the left
            } while (a[j] > pivot); // keep moving while the element > pivot, stop when <= pivot where the element is small enough to be on the left

            if (i >= j) { // when i >= j, everything is partitioned enough (low...j on <= pivot side and j+1...high >= pivot side)
                return j; // returns j (the split point) unlike Lomuto which returns pivot's final index
            }
            
            swap (a, i, j); // swap the two elements that are not yet sorted (a[i] >= pivot big enough to go to the right, a[j] <= pivot small enough to go to the left)
        }
    }

    // swap helper method to swap elements in the array
    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp; 
    }
}
