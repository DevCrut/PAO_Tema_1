package org.example.services;

import org.example.classes.User;
import org.example.classes.Wallet;
import org.example.repos.UserRepos;
import org.example.repos.WalletRepos;

import java.util.Scanner;

public class WalletService {
    WalletRepos repos;

    public WalletService(){
        repos = new WalletRepos();
    }

    public Wallet addWallet(Scanner s){
        System.out.println("Enter wallet id: ");
        int wallet_id = s.nextInt();

        System.out.println("Enter bonus points: ");
        int bonus_points = s.nextInt();

        System.out.println("Enter dollars: ");
        int dollars = s.nextInt();

        Wallet wallet = new Wallet(wallet_id, bonus_points, dollars);
        this.repos.addWallet(wallet);

        return wallet;
    }

    public Wallet modifyWallet(Wallet wallet, Scanner s){
        System.out.println("Enter wallet id: ");
        int wallet_id = s.nextInt();

        System.out.println("Enter bonus points: ");
        int bonus_points = s.nextInt();

        System.out.println("Enter dollars: ");
        int dollars = s.nextInt();

        wallet.setWallet_id(wallet_id);
        wallet.setBonus_points(bonus_points);
        wallet.setDollars(dollars);
        return wallet;
    }

    public void removeWallet(Scanner s)
    {
        System.out.println("Enter wallet id:");
        if(this.repos.removeWallet(s.nextInt()))
            System.out.println("Wallet removed successfully!");
        else
            System.out.println("Error");
    }
}
