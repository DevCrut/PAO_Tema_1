package org.example.services;

import org.example.classes.Software;
import org.example.csv.CSVWriter;
import org.example.repos.Service;
import org.example.repos.SoftwareRepos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.ResultSet;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.function.Consumer;

public class SoftwareService implements Service<Software> {

    SoftwareRepos repos;
    public SoftwareService(){
        repos = new SoftwareRepos();

        repos.listenAdd(new Consumer<Software>() {
            @Override
            public void accept(Software software) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(software);

                    CSVWriter.getInstance().write("ADDED DATA TO TABLE SOFTWARE," + CSVWriter.getInstance().escapeAndQuote(json));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        repos.listenModify(new Consumer<Software>() {
            @Override
            public void accept(Software software) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(software);

                    CSVWriter.getInstance().write("MODIFIED DATA FROM TABLE SOFTWARE," + CSVWriter.getInstance().escapeAndQuote(json));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        repos.listenRemove(new Consumer<Software>() {
            @Override
            public void accept(Software software) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(software);

                    CSVWriter.getInstance().write("REMOVED DATA FROM TABLE SOFTWARE," + CSVWriter.getInstance().escapeAndQuote(json));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void add(Software x) {
        repos.add(x);
    }

    @Override
    public void addMany(ArrayList<Software> x) {
        for (Software s : x) {
            repos.add(s);
        }
    }

    @Override
    public void remove(Software x) {
        repos.remove(x);
    }

    @Override
    public void removeMany(ArrayList<Software> x) {
        for (Software s : x){
            repos.remove(s);
        }
    }

    @Override
    public void modify(Software x) {
        repos.modify(x);
    }

    @Override
    public void modifyMany(ArrayList<Software> x) {
        for (Software s : x){
            repos.modify(s);
        }
    }

    public int getNextPrimaryKey() {
        try {
            repos.getQuery("select plt_software_sequence.nextval from dual");
            String sqlCommand = "select plt_software_sequence.currval from dual";
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
