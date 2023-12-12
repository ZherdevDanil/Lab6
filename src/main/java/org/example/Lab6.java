package org.example;

/*
 * C13 = 1505%13 = 10 => Визначити ієрархію тарифів мобільної компанії. Створити список тарифів
 *                           компанії. Порахувати загальну чисельність клієнтів. Провести сортування
 *                           тарифів на основі розміру абонентської плати. Знайти тариф у компанії, що
 *                           відповідає заданому діапазону вартості послуг.
 * */

import org.example.lab7.TariffSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lab6 {
    public static void main(String[] args) {
        TariffSet tariffs = new TariffSet();

        tariffs.add(new CheapTariff("SuperNet Start", 175, 140000));
        tariffs.add(new PremiumTariff("Ultra Vip", 900, 20000));
        tariffs.add(new MediumTariff("Red Unlim Max", 350, 115000));
        tariffs.add(new CheapTariff("Red Start", 150, 148000));
        tariffs.add(new PremiumTariff("Ultra", 600, 40000));

        for (Tariff tariff : sortTariffs(tariffs)) {
            System.out.println(tariff.toString());
        }

        System.out.println("\n" + "Number of users = " + Tariff.getNumberOfUsers(tariffs) + "\n");

        System.out.println("Required tariffs:");
        Tariff[] validTariffs = Tariff.getTariffsByMonthlyFeeSelectDiapason(tariffs, 890, 900);
        for (Tariff tariff : validTariffs) {
            System.out.println(tariff.toString());
        }
    }

    public static TariffSet sortTariffs(TariffSet tariffs){
        System.out.println("Tariffs sorted by monthly fee : ");
        List<Tariff> list = new ArrayList<>(tariffs);
        Collections.sort(list, new MonthlyFeeComparator<>());
        tariffs = new TariffSet(list);
        return tariffs;
    }
}