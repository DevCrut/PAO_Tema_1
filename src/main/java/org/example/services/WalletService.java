package org.example.services;

import org.example.classes.Wallet;
import org.example.csv.CSVWriter;
import org.example.repos.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.repos.WalletRepos;

import java.sql.ResultSet;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.function.Consumer;

public class WalletService implements Service<Wallet> {

    WalletRepos repos;
    public WalletService(){
        repos = new WalletRepos();

        repos.listenAdd(new Consumer<Wallet>() {
            @Override
            public void accept(Wallet software) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(software);

                    CSVWriter.getInstance().write("ADDED DATA TO TABLE WALLET," + CSVWriter.getInstance().escapeAndQuote(json));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        repos.listenModify(new Consumer<Wallet>() {
            @Override
            public void accept(Wallet software) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(software);

                    CSVWriter.getInstance().write("MODIFIED DATA FROM TABLE WALLET," + CSVWriter.getInstance().escapeAndQuote(json));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        repos.listenRemove(new Consumer<Wallet>() {
            @Override
            public void accept(Wallet software) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(software);

                    CSVWriter.getInstance().write("REMOVED DATA FROM TABLE WALLET," + CSVWriter.getInstance().escapeAndQuote(json));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void add(Wallet x) {
        repos.add(x);
    }

    @Override
    public void addMany(ArrayList<Wallet> x) {
        for (Wallet s : x) {
            repos.add(s);
        }
    }

    @Override
    public void remove(Wallet x) {
        repos.remove(x);
    }

    @Override
    public void removeMany(ArrayList<Wallet> x) {
        for (Wallet s : x){
            repos.remove(s);
        }
    }

    @Override
    public void modify(Wallet x) {
        repos.modify(x);
    }

    @Override
    public void modifyMany(ArrayList<Wallet> x) {
        for (Wallet s : x){
            repos.modify(s);
        }
    }

    public int getNextPrimaryKey() {
        try {
            repos.getQuery("select plt_wallet_sequence.nextval from dual");
            String sqlCommand = "select plt_wallet_sequence.currval from dual";
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
