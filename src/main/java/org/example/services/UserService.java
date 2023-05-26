package org.example.services;

import org.example.classes.Account;
import org.example.classes.Software;
import org.example.csv.CSVWriter;
import org.example.database.DatabaseManager;
import org.example.repos.Service;
import org.example.repos.UserRepos;
import org.example.repos.UserRepos;

import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class UserService implements Service<Account> {

    UserRepos repos;
    public UserService(){
        repos = new UserRepos();

        repos.listenAdd(new Consumer<Account>() {
            @Override
            public void accept(Account acc) {
                try {
                    CSVWriter.getInstance().write("ADDED DATA TO TABLE ACCOUNT," + acc.toString());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        repos.listenModify(new Consumer<Account>() {
            @Override
            public void accept(Account acc) {
                try {
                    CSVWriter.getInstance().write("MODIFIED DATA FROM TABLE ACCOUNT," + acc.toString());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        repos.listenRemove(new Consumer<Account>() {
            @Override
            public void accept(Account acc) {
                try {
                    CSVWriter.getInstance().write("REMOVED DATA FROM TABLE ACCOUNT," + acc.toString());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void add(Account x) {
        repos.add(x);
    }

    @Override
    public void addMany(ArrayList<Account> x) {
        for (Account s : x) {
            repos.add(s);
        }
    }

    @Override
    public void remove(Account x) {
        repos.remove(x);
    }

    @Override
    public void removeMany(ArrayList<Account> x) {
        for (Account s : x){
            repos.remove(s);
        }
    }

    @Override
    public void modify(Account x) {
        repos.modify(x);
    }

    @Override
    public void modifyMany(ArrayList<Account> x) {
        for (Account s : x){
            repos.modify(s);
        }
    }

    public int getNextPrimaryKey() {
        try {
            repos.getQuery("select plt_account_sequence.nextval from dual");
            String sqlCommand = "select plt_account_sequence.currval from dual";
            ResultSet res = repos.getQuery(sqlCommand);
            if (res.next()) {
                System.out.println("Returned PrimaryKey " + res.getInt(1));
                return res.getInt(1);
            } else {
                System.out.println("No value retrieved.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
