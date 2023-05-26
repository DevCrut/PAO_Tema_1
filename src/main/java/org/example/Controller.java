package org.example;

import org.example.classes.Account;
import org.example.classes.Software;
import org.example.database.DatabaseManager;
import org.example.exceptions.DatabaseConnectionException;
import org.example.services.SoftwareService;
import org.example.services.UserService;

import java.util.ArrayList;

public class Controller {
    private static UserService userService = new UserService();
    private static SoftwareService softwareService = new SoftwareService();

    private static DatabaseManager database = DatabaseManager.getInstance();

    Controller() throws DatabaseConnectionException {
        database.connect();
    }


    static Account addUser(Account x){
        x.setAccount_id(userService.getNextPrimaryKey());
        userService.add(x);
        return x;
    }
    static ArrayList<Account> addUserMany(ArrayList<Account> x){
        ArrayList<Account> ret = new ArrayList<>();
        for (Account a : x){
            ret.add(addUser(a));
        }
        return ret;
    }
    static void removeUser(Account x){
        userService.remove(x);
    }
    static void removeUserMany(ArrayList<Account> x){
        for (Account a : x){
            removeUser(a);
        }
    }
    static void modifyUser(Account x){
        userService.modify(x);
    }
    static void modifyUserMany(ArrayList<Account> x){
        for (Account a : x){
            modifyUser(a);
        }
    }

    static Software addSoftware(Software x){
        x.setSoftware_id(softwareService.getNextPrimaryKey());
        softwareService.add(x);
        return x;
    }
    static ArrayList<Software> addSoftwareMany(ArrayList<Software> x){
        ArrayList<Software> ret = new ArrayList<>();
        for (Software a : x){
            ret.add(addSoftware(a));
        }
        return ret;
    }
    static void removeSoftware(Software x){
        softwareService.remove(x);
    }
    static void removeSoftwareMany(ArrayList<Software> x){
        for (Software s : x){
            removeSoftware(s);
        }
    }
    static void modifySoftware(Software x){
        softwareService.modify(x);
    }
    static void modifySoftwareMany(ArrayList<Software> x){
        for (Software s : x){
            modifySoftware(s);
        }
    }
}
