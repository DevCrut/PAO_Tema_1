package org.example.classes;

public class Account {
    int account_id;
    int account_type;
    String account_name;
    String account_time_created;
    int wallet_id;

    public Account(int account_id){
        this.account_id = account_id;
    }
    public Account(int account_id, int account_type){
        this.account_id = account_id;
        this.account_type = account_type;
    }
    public Account(int account_id, int account_type, String account_name){
        this.account_id = account_id;
        this.account_type = account_type;
        this.account_name = account_name;
    }
    public Account(int account_id, int account_type, String account_name, String time_created){
        this.account_id = account_id;
        this.account_type = account_type;
        this.account_name = account_name;
        this.account_time_created = time_created;
    }
    public Account(int account_id, int account_type, String account_name, String time_created, int wallet){
        this.account_id = account_id;
        this.account_type = account_type;
        this.account_name = account_name;
        this.account_time_created = time_created;
        this.wallet_id = wallet;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getAccount_type() {
        return account_type;
    }

    public void setAccount_type(int account_type) {
        this.account_type = account_type;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getTime_created() {
        return account_time_created;
    }

    public void setTime_created(String time_created) {
        this.account_time_created = time_created;
    }

    public int getWallet() {
        return wallet_id;
    }

    public void setWallet(int wallet) {
        this.wallet_id = wallet;
    }
}
