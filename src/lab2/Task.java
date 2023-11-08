package lab2;

import lab1.Milk;

public class Task {
    static double sum;
    static int amount;

    public static double AvgPercent(Milk[] arr) {
        for (Milk milk : arr) {
            sum += milk.getFat();
        }
        return sum / arr.length;
    }

    public static int AmountAvailableMilk(Milk[] arr) {
        for (Milk milk : arr) {
            if (milk.isAvailability())
                amount++;
        }
        return amount;
    }
}
