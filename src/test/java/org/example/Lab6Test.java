package org.example;

import org.example.lab7.TariffSet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Lab6Test {
    Tariff tariff1=new CheapTariff("SuperNet Start", 175, 140000);
    Tariff tariff2=new PremiumTariff("Ultra Vip", 900, 20000);
    Tariff tariff3=new MediumTariff("Red Unlim Max", 350, 115000);
    Tariff tariff4=new CheapTariff("Red Start", 150, 148000);
    Tariff tariff5=new PremiumTariff("Ultra", 600, 40000);


    List<Tariff> tariffList = List.of(tariff1,tariff2,tariff3,tariff4,tariff5);
    List<Tariff> sortedTariffList = List.of(tariff2,tariff5,tariff3,tariff1,tariff4);


    TariffSet tariffSet = new TariffSet(tariffList);


    @Test
    public void testSortTariffs(){
        TariffSet sortedTarifSet = Lab6.sortTariffs(tariffSet);
        int i = 0 ;
        for (Tariff tariff:sortedTarifSet) {
            assertTrue(tariff.equals(sortedTariffList.get(i)));
            i++;
        }
    }

}