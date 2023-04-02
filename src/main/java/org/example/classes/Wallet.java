package org.example.classes;

public class Wallet {
    int bonus_points;
    int dollars;

    public Wallet(int bonus_points) {
        this.bonus_points = bonus_points;
    }

    public Wallet(int bonus_points, int dollars) {
        this.bonus_points = bonus_points;
        this.dollars = dollars;
    }

    public int getBonus_points() {
        return bonus_points;
    }

    public void setBonus_points(int bonus_points) {
        this.bonus_points = bonus_points;
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }
}
