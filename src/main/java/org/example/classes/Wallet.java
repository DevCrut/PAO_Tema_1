package org.example.classes;

public class Wallet {

    int wallet_id;
    int bonus_points;
    int dollars;

    public Wallet(int wallet_id) {
        this.wallet_id = bonus_points;
    }

    public Wallet(int wallet_id, int bonus_points) {
        this.wallet_id = bonus_points;
        this.bonus_points = bonus_points;
    }

    public Wallet(int wallet_id, int bonus_points, int dollars) {
        this.wallet_id = bonus_points;
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

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {
        this.wallet_id = wallet_id;
    }
}
