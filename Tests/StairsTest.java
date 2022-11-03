import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StairsTest {

    Stairs stairs;

    @BeforeEach
    void SetUp() {
        stairs = new Stairs();
    }

    @Test
    void forOnePositiveNumber() {
        int[] array = {1};
        long result = stairs.findMaxSum(array);
        assertEquals(1, result);
    }

    @Test
    void forOneNegativeNumber() {
        int[] array = {-20};
        long result = stairs.findMaxSum(array);
        assertEquals(-20, result);
    }

    @Test
    void forMonoArray() {
        int[] array = new int[21];
        int k = 15;
        array[0] = 0;
        for (int i = 1; i < 21; i++) {
            array[i] = k;
        }
        long result = stairs.findMaxSum(array);
        assertEquals(300, result);
    }

    @Test
    void forPositiveNumbers() {
        int[] array = new int[21];
        int k = 10;
        array[0] = 0;
        for (int i = 1; i < 21; i++) {
            array[i] = k;
            k += 10;
        }
        long result = stairs.findMaxSum(array);
        assertEquals(2100, result);
    }

    @Test
    void forNegativeNumbers() {
        int[] array = new int[11];
        int k = -100;
        array[0] = 0;
        for (int i = 1; i < 11; i++) {
            array[i] = k;
            k = k - 10;
        }
        long result = stairs.findMaxSum(array);
        assertEquals(-750, result);
    }

    @Test
    void forMixedNumbersInPositiveNegativeOrder() {
        int[] array = new int[10];
        int pos = 10;
        int neg = -5;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) array[i] = pos + i;
            else array[i] = neg - i;
        }
        long result = stairs.findMaxSum(array);
        assertEquals(56, result);
    }

    @Test
    void forMixedNumbersInPositiveNegativeOrder2() {
        int[] array = new int[10];
        int pos = 10;
        int neg = -5;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) array[i] = neg - i;
            else array[i] = pos + i;
        }
        long result = stairs.findMaxSum(array);
        assertEquals(75, result);
    }

    @Test
    void forMixedNumbersInRandomOrder() {
        int[] array = {-20, 90, 30, 40, -50, -10, -100, 100, -1};
        long result = stairs.findMaxSum(array);
        assertEquals(249, result);
    }

    @Test
    void forMixedNumbersInRandomOrder2() {
        int[] array = {-20, -90, -30, -40, -50, -10, -100, 100, -1};
        long result = stairs.findMaxSum(array);
        assertEquals(-1, result);
    }

    @Test
    void trickyTest() {
        int[] array = {0, 1, 1, -2, -4, -6, 2, 2};
        long result = stairs.findMaxSum(array);
        assertEquals(2, result);
    }
}