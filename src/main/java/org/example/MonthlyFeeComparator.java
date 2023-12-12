package org.example;

import java.util.Comparator;

public class MonthlyFeeComparator<E> implements Comparator<Tariff> {
    @Override
    public int compare(Tariff o1, Tariff o2) {
        if (o1.getMonthlyFee() == o2.getMonthlyFee()) {
            return 0;
        } else if (o1.getMonthlyFee() < o2.getMonthlyFee()) {
            return 1;
        } else {
            return -1;
        }
    }
}
