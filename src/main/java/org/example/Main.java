package org.example;

import org.example.classes.*;
import org.example.csv.CSVWriter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Controller controller;

    public static void main(String[] args) throws Exception {
        controller = new Controller();
        ArrayList<Account> data = new ArrayList<>();
        data.add(new Account(-1, 2, "Mike2", "26/MAY/2023", 10));
        data.add(new Account(-1, 2, "Mike3", "26/MAY/2023", 11));
        data = controller.addUserMany(data);
        ArrayList<Software> data2 = new ArrayList<>();
        data2.add(new Software(-1, data.get(0).getAccount_id(), 2, "ROFL", "11/AUG/2023"));
        data2.add(new Software(-1, data.get(1).getAccount_id(), 2, "CS1.6", "11/AUG/2023"));

        controller.addSoftwareMany(data2);
        data.get(0).setAccount_name("Mike4");
        data.get(1).setAccount_name("Mike5");
        controller.modifyUserMany(data);
        data2.get(0).setSoftware_name("R.O.F.L.");
        data2.get(1).setSoftware_name("CS 1.6");
        controller.modifySoftwareMany(data2);
        controller.removeUserMany(data);
        controller.removeSoftwareMany(data2);

        CSVWriter.getInstance().endTask();
    }
}
