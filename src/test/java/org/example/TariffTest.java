package org.example;

import org.example.lab7.TariffSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TariffTest {

    Tariff tariff1 = new CheapTariff("SuperNet Start", 175, 140000);
    Tariff tariff2 = new PremiumTariff("Ultra Vip", 900, 20000);
    Tariff tariff3 = new MediumTariff("Red Unlim Max", 350, 115000);
    TariffSet tariffSet = new TariffSet();

    @BeforeEach
    public void setUp(){
        tariffSet.add(tariff1);
        tariffSet.add(tariff2);
        tariffSet.add(tariff3);
    }

    @Test
    public void testGetNumberOfUsers(){
        int expectedNumberOfUsers = tariff1.getNumberOfClients() + tariff2.getNumberOfClients() + tariff3.getNumberOfClients();
        assertEquals(expectedNumberOfUsers,Tariff.getNumberOfUsers(tariffSet));
    }

    @Test
    public void testGetTariffsByMonthlyFeeSelectDiapason(){
        Tariff[] expectedArrayOfTariffs = {tariff2};
        Tariff[] gettedByGetTariffsByMonthlyFeeSelectDiapason = Tariff.getTariffsByMonthlyFeeSelectDiapason(tariffSet,800,1000);
        assertEquals(expectedArrayOfTariffs[0],gettedByGetTariffsByMonthlyFeeSelectDiapason[0]);

    }



}