import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyPrQueueTest {

    @Test
    public void forOneNode() {
        MyPrQueue prQueue = new MyPrQueue();
        prQueue.insert(200);
        assertEquals(200, prQueue.extractMax());
    }

    @Test
    public void forTwoNodes() {
        MyPrQueue prQueue = new MyPrQueue();
        prQueue.insert(200);
        prQueue.insert(300);
        assertEquals(300, prQueue.extractMax());
        assertEquals(200, prQueue.extractMax());
    }

    @Test
    public void forThreeNodes() {
        MyPrQueue prQueue = new MyPrQueue();
        prQueue.insert(200);
        prQueue.insert(300);
        prQueue.insert(500);
        assertEquals(500, prQueue.extractMax());
        assertEquals(300, prQueue.extractMax());
        assertEquals(200, prQueue.extractMax());

    }

    @Test
    public void fullTree() {
        MyPrQueue prQueue = new MyPrQueue();
        prQueue.insert(200);
        prQueue.insert(300);
        prQueue.insert(500);
        prQueue.insert(20);
        prQueue.insert(400);
        prQueue.insert(1);
        prQueue.insert(5);
        prQueue.insert(700);
        prQueue.insert(900);
        prQueue.insert(60);
        prQueue.insert(800);
        prQueue.insert(55);
        prQueue.insert(2);
        prQueue.insert(20);
        prQueue.insert(20);
        prQueue.insert(6);
        prQueue.insert(7);
        prQueue.insert(8);
        prQueue.insert(9);
        prQueue.insert(10);
        prQueue.insert(11);
        prQueue.insert(12);
        prQueue.insert(13);
        prQueue.insert(14);

        assertEquals(900, prQueue.extractMax());
        assertEquals(800, prQueue.extractMax());
        assertEquals(700, prQueue.extractMax());
        assertEquals(500, prQueue.extractMax());
        assertEquals(400, prQueue.extractMax());
        assertEquals(300, prQueue.extractMax());
        assertEquals(200, prQueue.extractMax());
        assertEquals(60, prQueue.extractMax());
        assertEquals(55, prQueue.extractMax());
        assertEquals(20, prQueue.extractMax());
        assertEquals(20, prQueue.extractMax());
        assertEquals(20, prQueue.extractMax());
        assertEquals(14, prQueue.extractMax());
        assertEquals(13, prQueue.extractMax());
        assertEquals(12, prQueue.extractMax());
        assertEquals(11, prQueue.extractMax());
        assertEquals(10, prQueue.extractMax());
        assertEquals(9, prQueue.extractMax());
        assertEquals(8, prQueue.extractMax());
        assertEquals(7, prQueue.extractMax());
        assertEquals(6, prQueue.extractMax());
        assertEquals(5, prQueue.extractMax());

        assertEquals(2, prQueue.extractMax());
        assertEquals(1, prQueue.extractMax());
    }

    @Test
    public void fullTreeWithCombinedOperations() {
        MyPrQueue prQueue = new MyPrQueue();
        prQueue.insert(200);
        prQueue.insert(300);
        prQueue.insert(500);
        prQueue.insert(20);
        prQueue.insert(400);
        prQueue.insert(1);
        prQueue.insert(5);
        assertEquals(500, prQueue.extractMax());
        assertEquals(400, prQueue.extractMax());
        prQueue.insert(10000);
        prQueue.insert(1000);
        assertEquals(10000, prQueue.extractMax());
        assertEquals(1000, prQueue.extractMax());
        assertEquals(300, prQueue.extractMax());
        prQueue.insert(70);
        assertEquals(200, prQueue.extractMax());
        assertEquals(70, prQueue.extractMax());
        assertEquals(20, prQueue.extractMax());
        assertEquals(5, prQueue.extractMax());
        assertEquals(1, prQueue.extractMax());
    }

    @Test
    public void rightChildIsAbsentInRightBranch() {
        MyPrQueue prQueue = new MyPrQueue();
        prQueue.insert(200);
        prQueue.insert(300);
        prQueue.insert(500);
        prQueue.insert(20);
        prQueue.insert(400);
        prQueue.insert(1);
        assertEquals(500, prQueue.extractMax());
        assertEquals(400, prQueue.extractMax());
        assertEquals(300, prQueue.extractMax());
        assertEquals(200, prQueue.extractMax());
        assertEquals(20, prQueue.extractMax());
        assertEquals(1, prQueue.extractMax());
    }

    @Test
    public void leftBranch() {
        MyPrQueue prQueue = new MyPrQueue();
        prQueue.insert(200);
        prQueue.insert(300);
        prQueue.insert(500);
        prQueue.insert(20);
        prQueue.insert(400);
        assertEquals(500, prQueue.extractMax());
        assertEquals(400, prQueue.extractMax());
        assertEquals(300, prQueue.extractMax());
        assertEquals(200, prQueue.extractMax());
        assertEquals(20, prQueue.extractMax());
    }

    @Test
    public void rightChildIsAbsentInLeftBranch() {
        MyPrQueue prQueue = new MyPrQueue();
        prQueue.insert(200);
        prQueue.insert(300);
        prQueue.insert(500);
        prQueue.insert(50);
        prQueue.insert(100);
        prQueue.insert(40);
        prQueue.insert(30);
        assertEquals(500, prQueue.extractMax());
        assertEquals(300, prQueue.extractMax());
        assertEquals(200, prQueue.extractMax());
        assertEquals(100, prQueue.extractMax());
        assertEquals(50, prQueue.extractMax());
        assertEquals(40, prQueue.extractMax());
        assertEquals(30, prQueue.extractMax());
    }

    @Test
    public void test() {
        boolean fail = false;
        for (int j = 0; j < 10; j++) {
            System.out.println("amount try " + j);
            MyPrQueue prQueue = new MyPrQueue();
            Random random = new Random();
            ArrayList<Integer> input = new ArrayList<>();
            ArrayList<Integer> sorted = new ArrayList<>();
            int max = 30000;
            for (int i = 1; i < max; i++) {
                int value = random.nextInt(Integer.MAX_VALUE) & Integer.MAX_VALUE;
                input.add(value);
                sorted.add(value);
            }
            sorted.forEach(prQueue::insert);
            sorted.sort(Collections.reverseOrder());

            for (Integer integer : sorted) {
                if (integer != prQueue.extractMax()) {
                    fail = true;
                    break;
                }
            }
            if (fail) {
                input.forEach(System.out::println);
                break;
            }
        }
        if (fail) Assertions.fail();
    }
}