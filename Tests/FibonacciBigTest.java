import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

class FibonacciBigTest extends FibonacciBig {
    @Test
    public void forOne() {
        assertEquals(1, FibonacciBig.getFibonacciNumBig(1,2));
    }
    @Test
    public void forNoRemainSimple() {
        assertEquals(0, FibonacciBig.getFibonacciNumBig(6,2));
        assertEquals(0, FibonacciBig.getFibonacciNumBig(20,5));
    }
    @Test
    public void forRemainSimple() {
        assertEquals(1, FibonacciBig.getFibonacciNumBig(10,3));
        assertEquals(2, FibonacciBig.getFibonacciNumBig(30,3));
    }
    @Test
    public void forRemainBig() {
        assertEquals(2842, FibonacciBig.getFibonacciNumBig(100,7777));
        assertEquals(82726599, FibonacciBig.getFibonacciNumBig(8000000,123456789));
    }
}