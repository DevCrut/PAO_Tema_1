package org.example.classes;

import java.util.ArrayList;

public class User extends Account {
    ArrayList<Software> owned_items;

    public User(int account_id) {
        super(account_id);
    }

    public User(int account_id, String account_name) {
        super(account_id, account_name);
    }

    public User(int account_id, String account_name, int time_created) {
        super(account_id, account_name, time_created);
    }

    public User(int account_id, String account_name, int time_created, Wallet wallet) {
        super(account_id, account_name, time_created, wallet);
    }

    public ArrayList<Software> getOwnedItems() {
        return owned_items;
    }

    public void setOwnedItems(ArrayList<Software> owned_items) {
        this.owned_items = owned_items;
    }
}
