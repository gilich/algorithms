import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class BigBag {
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

    public static class SortByCostPerKilo implements Comparator<Thing> {
        @Override
        public int compare(Thing o1, Thing o2) {
            return Double.compare(o2.costPerKilo, o1.costPerKilo);
//            return (int)(o2.getCostPerKilo() - o1.getCostPerKilo());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfThings = scanner.nextInt();
        double weightOfBag = scanner.nextInt();
        ArrayList<Thing> listOfThings = new ArrayList<>();
        for (int i = 0; i < amountOfThings; i++) {
            double price = scanner.nextInt();
            double weight = scanner.nextInt();
            double costPerKilo = price / weight;
            Thing thing = new Thing(price, weight, costPerKilo);
            listOfThings.add(thing);
        }
        scanner.close();
        Collections.sort(listOfThings, new SortByCostPerKilo());


        double result = findBestSolution(listOfThings, weightOfBag);
        System.out.printf("%.3f", result);
    }

    public static double findBestSolution(ArrayList<Thing> listOfThings, double weightOfBag) {
        double maxCost = 0;
        for (Thing thing : listOfThings) {
            if (weightOfBag == 0) {
                break;
            }
            if (thing.getWeight() <= weightOfBag) {
                maxCost += thing.getPrice();
                weightOfBag = weightOfBag - thing.getWeight();
            } else {
                maxCost += thing.getCostPerKilo() * weightOfBag;
                weightOfBag = 0.0;
            }
        }
        return maxCost;
    }
}
