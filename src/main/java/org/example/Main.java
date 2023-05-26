package org.example;

import org.example.classes.*;
import org.example.database.DatabaseManager;
import org.example.services.SoftwareService;
import org.example.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static UserService userService = new UserService();
    static SoftwareService softwareService = new SoftwareService();

    static DatabaseManager database = DatabaseManager.getInstance();

    public static void main(String[] args) throws Exception {
        database.connect();
        ArrayList<Account> data = new ArrayList<>();
        data.add(new Account(10, 2, "Mike2", "26/MAY/2023", 10));
        data.add(new Account(11, 2, "Mike3", "26/MAY/2023", 11));
        userService.addMany(data);
        userService.removeMany(data);
        database.disconnect();
    }
}
