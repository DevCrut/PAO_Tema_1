package org.example.repos;

import org.example.classes.Software;
import org.example.database.DatabaseManager;
import org.example.services.Repos;

import java.util.ArrayList;

public non-sealed class SoftwareRepos extends Observer<Software> implements Repos<Software> {

    private static DatabaseManager database = DatabaseManager.getInstance();
    @Override
    public void add(Software x) {
        triggerAdd(x);
    }

    @Override
    public void remove(Software x) {
        triggerRemove(x);
    }

    @Override
    public void modify(Software x) {
        triggerModify(x);
    }

    @Override
    public ArrayList<Software> getQuery(String query) {
        return null;
    }
}
