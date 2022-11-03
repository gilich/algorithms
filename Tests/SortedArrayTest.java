import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayTest {
    SortedArray check;

    @BeforeEach
    void setUp() {
        check = new SortedArray();
    }

    @Test
    void forOneElement() {
        int[] array = {13};
        assertEquals(array, check.mergeSort(array));
    }
    @Test
    void forEvenNumberOfElementsInSortedArray() {
        int[] array = {1, 3, 5, 8, 10, 20, 30};
        assertEquals(array, check.mergeSort(array));
    }
    @Test
    void forOddNumberOfElementsInUnsortedArrayWithUnrepeatedNumbers() {
        int[] array = {10, 4, 100, 500, 30, 1, 6, 7, 13, 600, 40, 666, 777, 2};
        int [] sorted = {1, 2, 4, 6, 7, 10, 13, 30, 40, 100, 500, 600, 666, 777};
        assertEquals(sorted, check.mergeSort(array));
    }
    @Test
    void forUnsortedArrayWithRepeatedNumbers() {
        int[] array = {10, 4, 100, 500, 30, 1, 6, 7, 1, 100, 4, 666, 777, 1};
        int [] sorted = {1, 1, 1, 4, 4, 6, 7, 10, 30, 100, 100, 500, 666, 777};
        assertEquals(sorted, check.mergeSort(array));
    }
    @Test
    void forSortedArrayWithRepeatedNumbers() {
        int[] array = {1, 1, 1, 4, 4, 6, 7, 10, 30, 100, 100, 500, 666, 777};
        int [] sorted = {1, 1, 1, 4, 4, 6, 7, 10, 30, 100, 100, 500, 666, 777};
        assertEquals(sorted, check.mergeSort(array));
    }
    @Test
    void forOneRepeatedNumber() {
        int[] array = {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7};
        assertEquals(array, check.mergeSort(array));
    }
}