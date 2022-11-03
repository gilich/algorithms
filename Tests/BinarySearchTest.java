import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    BinarySearch check;

    @BeforeEach
    void setUp() {
        check = new BinarySearch();
    }

    @Test
    void forOneNumberInGivenArray() {
        int[] given = {1};
        int[] needed = {1, 2, 3, 4, 5};
        StringBuilder sb = new StringBuilder();
        for (int number : needed) {
            sb.append(check.findNumbers(given, number) + " ");
        }
        assertEquals("1 -1 -1 -1 -1 ", sb.toString());
    }

    @Test
    void forOneNumberInNeededArray() {
        int[] given = {10, 20, 30, 40};
        int[] needed = {30};
        StringBuilder sb = new StringBuilder();
        for (int number : needed) {
            sb.append(check.findNumbers(given, number) + " ");
        }
        assertEquals("3 ", sb.toString());
    }

    @Test
    void forOneNumberInBoth() {
        int[] given = {10};
        int[] needed = {30};
        StringBuilder sb = new StringBuilder();
        for (int number : needed) {
            sb.append(check.findNumbers(given, number) + " ");
        }
        assertEquals("-1 ", sb.toString());
    }

    @Test
    void forFullMatch() {
        int[] given = {1, 40, 77, 100, 200, 500, 600, 800};
        int[] needed = {1, 40, 77, 100, 200, 500, 600, 800};
        StringBuilder sb = new StringBuilder();
        for (int number : needed) {
            sb.append(check.findNumbers(given, number) + " ");
        }
        assertEquals("1 2 3 4 5 6 7 8 ", sb.toString());
    }

    @Test
    void forMisMatch() {
        int[] given = {1, 40, 77, 100, 200, 500, 600, 800};
        int[] needed = {2, 41, 78, 101, 201, 501, 601, 801};
        StringBuilder sb = new StringBuilder();
        for (int number : needed) {
            sb.append(check.findNumbers(given, number) + " ");
        }
        assertEquals("-1 -1 -1 -1 -1 -1 -1 -1 ", sb.toString());
    }

    @Test
    void forParticularMatch() {
        StringBuilder sb = new StringBuilder();
        int[] given = new int[100];
        for (int i = 0; i < 100; i++) {
            given[i] = i;
        }
        int[] needed = new int[100];
        for (int i = 0; i < 20; i++) {
            needed[i] = i * 10;
            sb.append(check.findNumbers(given, needed[i]) + " ");
        }
        assertEquals("1 11 21 31 41 51 61 71 81 91 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 ", sb.toString());
    }
}