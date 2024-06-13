import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int profit;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(int[] weights, int[] profit, int capacity) {
        Item[] items = new Item[weights.length];
        for (int i = 0; i < weights.length; i++) {
            items[i] = new Item(weights[i], profit[i]);
        }

        Arrays.sort(items, Comparator.comparingDouble((Item i) -> (double) i.profit / i.weight).reversed());

        double maxValue = 0;
        for (Item item : items) {
            if (capacity - item.weight >= 0) {
                capacity -= item.weight;
                maxValue += item.profit;
                System.out.println("Added item with: Profit= "+item.profit+", Weight= "+item.weight);
            } else {
                double fraction = (double) capacity / item.weight;
                maxValue += fraction * item.profit;
                System.out.println("Added "+fraction+" portion of item with: Profit= "+item.profit+", Weight= "+item.weight);
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum profit that can be obtained = " + maxValue);
    }
}
