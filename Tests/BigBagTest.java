import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BigBagTest extends BigBag{
    public static class Thing {
        private double price;
        private double weight = 1;
        private double costPerKilo = price / weight;

        public Thing(double price, double weight, double costPerKilo) {
            this.price = price;
            this.weight = weight;
            this.costPerKilo = costPerKilo;
        }

        public double getPrice() {
            return price;
        }

        public double getWeight() {
            return weight;
        }

        public double getCostPerKilo() {
            return costPerKilo;
        }
    }
    public static class SortByCostPerKilo implements Comparator<BigBag.Thing> {
        @Override
        public int compare(BigBag.Thing o1, BigBag.Thing o2) {
            return (int)(o2.getCostPerKilo() - o1.getCostPerKilo());
        }
    }
    @Test
    public void success(){
        System.out.println("Successful test");
        Thing first = new Thing(60,20,3);
        Thing second = new Thing(100,50,2);
        Thing third = new Thing(120,30,4);
        ArrayList <Thing> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
//        Collections.sort(list, new SortByCostPerKilo());
    }
}