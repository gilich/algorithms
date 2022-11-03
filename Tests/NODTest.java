import org.junit.Assert;
import org.junit.Test;

class NODTest extends NOD{
    int a;
    int b;
    @Test
    public void forBothZero(){
        System.out.println("This case is for a = 0 and b = 0");
        a = 0;
        b = 0;
        int result =  0;
        Assert.assertEquals("The result must be 0.", result,NOD.getNOD(a,b));
    }
    @Test
    public void forSmallEasy(){
        System.out.println("This case is for a = 100 and b = 25");
        a = 100;
        b = 25;
        int result =  4;
        Assert.assertEquals("The result must be 4.", result,NOD.getNOD(a,b));
    }
    @Test
    public void forBigNumbers(){
        System.out.println("This case is for a = 123456789 and b = 987654321");
        a = 123456789;
        b = 987654321;
        int result =  9;
        Assert.assertEquals("The result must be 9.", result,NOD.getNOD(a,b));
    }
}