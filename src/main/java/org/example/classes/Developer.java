package org.example.classes;

import java.util.ArrayList;

public class Developer extends Account {
    ArrayList<Software> created_items;

    public Developer(int account_id) {
        super(account_id);
    }

    public Developer(int account_id, String account_name) {
        super(account_id, account_name);
    }

    public Developer(int account_id, String account_name, int time_created) {
        super(account_id, account_name, time_created);
    }

    public Developer(int account_id, String account_name, int time_created, Wallet wallet) {
        super(account_id, account_name, time_created, wallet);
    }

    public ArrayList<Software> getCreated_items() {
        return created_items;
    }

    public void setCreated_items(ArrayList<Software> created_items) {
        this.created_items = created_items;
    }
}
