package org.example;

import org.example.lab7.TariffSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthlyFeeComparatorTest {

    Tariff tariff1 = new CheapTariff("SuperNet Start", 175, 140000);
    Tariff tariff2 =new PremiumTariff("Ultra Vip", 900, 20000);

    Tariff tariff3 = new PremiumTariff("dfvafaeg", 900, 20000);
    MonthlyFeeComparator monthlyFeeComparator = new MonthlyFeeComparator();

    @Test
    public void testCompare(){
        assertEquals(1,monthlyFeeComparator.compare(tariff1,tariff2));
        assertEquals(0,monthlyFeeComparator.compare(tariff2,tariff3));
        assertEquals(-1,monthlyFeeComparator.compare(tariff2,tariff1));
    }

}