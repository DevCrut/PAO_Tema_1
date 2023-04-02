package org.example.classes;

public class Account {
    int account_id;
    String account_name;
    int time_created;
    Wallet wallet;

    public Account(int account_id){
        this.account_id = account_id;
    }
    public Account(int account_id, String account_name){
        this.account_id = account_id;
        this.account_name = account_name;
    }
    public Account(int account_id, String account_name, int time_created){
        this.account_id = account_id;
        this.account_name = account_name;
        this.time_created = time_created;
    }
    public Account(int account_id, String account_name, int time_created, Wallet wallet){
        this.account_id = account_id;
        this.account_name = account_name;
        this.time_created = time_created;
        this.wallet = wallet;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public int getTime_created() {
        return time_created;
    }

    public void setTime_created(int time_created) {
        this.time_created = time_created;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
