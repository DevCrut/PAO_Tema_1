package org.example;

import org.example.classes.Software;
import org.example.classes.Wallet;
import org.example.services.SoftwareService;
import org.example.services.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.sql.*;

public class Main {
    static UserService userService = new UserService();
    static SoftwareService softwareService = new SoftwareService();

    public static void main(String[] args) throws Exception {
        /*Scanner s = new Scanner(System.in);
        User user = userService.addUser(s);
        Wallet wallet = walletService.addWallet(s);

        Software soft = softwareService.addSoftware(s);
        ArrayList<Software> gameSet = new ArrayList<>();
        gameSet.add(soft);

        user.setWallet(wallet);
        user.setOwnedItems(gameSet);*/

    }
}
