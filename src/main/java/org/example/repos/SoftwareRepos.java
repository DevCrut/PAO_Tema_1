package org.example.repos;

import org.example.classes.Software;
import org.example.database.DatabaseManager;
import org.example.services.Repos;

import java.util.ArrayList;

public non-sealed class SoftwareRepos extends Observer implements Repos<Software> {

    private static DatabaseManager database = DatabaseManager.getInstance();
    @Override
    public void add(Software x) {
        triggerAdd(0, 0);
    }

    @Override
    public void remove(Software s) {
        triggerRemove(0, 0);
    }

    @Override
    public void modify(Software x) {
        triggerModify(0, 0);
    }

    @Override
    public ArrayList<Software> getQuery(String query) {
        return null;
    }
}
