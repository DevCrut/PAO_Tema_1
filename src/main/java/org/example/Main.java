package org.example;

import org.example.classes.Software;
import org.example.classes.User;
import org.example.classes.Wallet;
import org.example.services.SoftwareService;
import org.example.services.UserService;
import org.example.services.WalletService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    static WalletService walletService = new WalletService();
    static UserService userService = new UserService();
    static SoftwareService softwareService = new SoftwareService();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        User user = userService.addUser(s);
        Wallet wallet = walletService.addWallet(s);

        Software soft = softwareService.addSoftware(s);
        ArrayList<Software> gameSet = new ArrayList<>();
        gameSet.add(soft);

        user.setWallet(wallet);
        user.setOwnedItems(gameSet);
    }
}
