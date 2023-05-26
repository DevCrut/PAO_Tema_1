package org.example.services;

import org.example.classes.Software;
import org.example.csv.CSVWriter;
import org.example.repos.Service;
import org.example.repos.SoftwareRepos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class SoftwareService implements Service<Software> {

    SoftwareRepos repos;
    public SoftwareService(){
        repos = new SoftwareRepos();

        repos.listenAdd(new Consumer<Software>() {
            @Override
            public void accept(Software software) {
                try {
                    CSVWriter.getInstance().write("ADDED DATA TO TABLE SOFTWARE," + software.toString());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        repos.listenModify(new Consumer<Software>() {
            @Override
            public void accept(Software software) {
                try {
                    CSVWriter.getInstance().write("MODIFIED DATA FROM TABLE SOFTWARE," + software.toString());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        repos.listenRemove(new Consumer<Software>() {
            @Override
            public void accept(Software software) {
                try {
                    CSVWriter.getInstance().write("REMOVED DATA FROM TABLE SOFTWARE," + software.toString());
                } catch (FileNotFoundException e) {
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
}
