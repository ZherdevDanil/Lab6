package org.example;

/*
 * C13 = 1505%13 = 10 => Визначити ієрархію тарифів мобільної компанії. Створити список тарифів
 *                           компанії. Порахувати загальну чисельність клієнтів. Провести сортування
 *                           тарифів на основі розміру абонентської плати. Знайти тариф у компанії, що
 *                           відповідає заданому діапазону вартості послуг.
 * */

import java.util.Arrays;

public class Lab6 {
    public static void main(String[] args) {

        Tariff[] tariffs = new Tariff[]{
                new CheapTariff("SuperNet Start", 175, 140000),
                new PremiumTariff("Ultra Vip", 900, 20000),
                new MediumTariff("Red Unlim Max", 350, 115000),
                new CheapTariff("Red Start", 150, 148000),
                new PremiumTariff("Ultra", 600, 40000),

        };

        System.out.println("Tariffs sorted by monthly fee : ");
        Arrays.sort(tariffs, new MonthlyFeeComparator());
        for (Tariff tariff : tariffs) {
            System.out.println(tariff.toString());
        }
        System.out.println("\n" + "Number of users = " + Tariff.getNumberOfUsers(tariffs) + "\n");

        System.out.println("Required tariffs:");
        Tariff[] validTariffs = Tariff.getTariffsByMonthlyFeeSelectDiapason(tariffs, 890, 900);
        for (Tariff tariff : validTariffs) {
            System.out.println(tariff.toString());
        }

    }
}