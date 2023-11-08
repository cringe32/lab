package lab2;

import lab1.Milk;
import lab1.WriterInfo;

public class Lab2 {
    public static void main(String[] args) {
        Milk[] m = new Milk[5];
        m[0] = new Milk();
        m[1] = new Milk("Свежие новости");
        m[2] = new Milk("Бабушкина крынка", 2.8);
        m[3] = new Milk("Горки", 3.2, false);
        m[4] = new Milk(m[3]);

        WriterInfo.writeInfo(m[3]);
        System.out.format("Средняя жирность молока: %.2f%%\n", Task.AvgPercent(m));
        System.out.format("Количество видов молока на складе: %s\n", Task.AmountAvailableMilk(m));
    }
}

