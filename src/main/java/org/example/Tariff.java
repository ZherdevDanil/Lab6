package org.example;

import org.example.lab7.TariffSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Tariff {

    private String name;
    private double monthlyFee;
    private int numberOfClients;

    public Tariff(String name, double monthlyFee, int numberOfClients) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.numberOfClients = numberOfClients;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", monthlyFee=" + monthlyFee +
                        ", numberOfClients=" + numberOfClients;
    }

    public static int getNumberOfUsers(TariffSet tariffs) {
        int numberOfAllUsers = 0;
        for (Tariff tariff : tariffs) {
            numberOfAllUsers += tariff.getNumberOfClients();
        }
        return numberOfAllUsers;
    }

    public static Tariff[] getTariffsByMonthlyFeeSelectDiapason(TariffSet tariffs, int leftDiapasonEdge, int rightDiapasonEdge) {
        List<Tariff> valideTariffs = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getMonthlyFee() >= leftDiapasonEdge && tariff.getMonthlyFee() <= rightDiapasonEdge) {
                valideTariffs.add(tariff);
            }
        }
        return valideTariffs.toArray(new Tariff[0]);
    }
}
