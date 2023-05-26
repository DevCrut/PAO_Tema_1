package org.example.services;

import org.example.classes.Software;
import org.example.repos.Service;
import org.example.repos.SoftwareRepos;

import java.util.ArrayList;
import java.util.Scanner;

public class SoftwareService implements Service<Software> {

    Repos<Software> repos;
    public SoftwareService(){
        repos = new SoftwareRepos();
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
