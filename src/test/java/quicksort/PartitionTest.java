package quicksort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PartitionTest {

    private static final int[] SORTED = 
        {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

    private static final int[] UNSORTED = 
        {84, 3, 7, 1, 9, 6, 2, 5, };

    private static final int[] EMPTY = {};

    @Test
    void lomuto_partition_onSortedArray() {
        int[] a = Arrays.copyOf(SORTED, SORTED.length);

        int p = LomutoPartition.partition(a, 0, a.length - 1);

        assertEquals(a.length - 1, p);
        assertArrayEquals(SORTED, a);
    }

    @Test
    void lomuto_partition_onUnsortedArray() {
        int[] a = Arrays.copyOf(UNSORTED, UNSORTED.length);

        int p = LomutoPartition.partition(a, 0, a.length - 1);

        int[] expected = {3, 1, 2, 5, 9, 6, 7, 84};
        assertEquals(3, p);
        assertArrayEquals(expected, a);
    }

    @Test 
    void lomuto_partition_onEmptyArray_returnsMinusOne() {
        int p = LomutoPartition.partition(EMPTY, 0, -1);
        assertEquals(-1, p);
    }

    @Test
    void hoare_partition_onSortedArray() {
        int[] a = Arrays.copyOf(SORTED, SORTED.length);

        int p = HoarePartition.partition(a, 0, a.length - 1);

        assertEquals(0, p);
        assertArrayEquals(SORTED, a);
    }

    @Test
    void hoare_partition_onUnsortedArray() {
        int[] a = Arrays.copyOf(UNSORTED, UNSORTED.length);

        int p = HoarePartition.partition(a, 0, a.length - 1);

        int[] expected = {5, 3, 7, 1, 9, 6, 2, 84};
        assertEquals(6, p);
        assertArrayEquals(expected, a);
    }

    @Test
    void hoare_partition_onEmptyArray_returnsMinusOne() {
        int p = HoarePartition.partition(EMPTY, 0, -1);
        assertEquals(-1, p);
    }
}
