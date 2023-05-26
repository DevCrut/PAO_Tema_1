package org.example.repos;

import org.example.classes.*;
import org.example.database.DatabaseManager;
import org.example.services.Repos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;

public non-sealed class UserRepos extends Observer<Account> implements Repos<Account> {

    private static DatabaseManager database = DatabaseManager.getInstance();
    @Override
    public void add(Account x) {
        triggerAdd(x);
    }

    @Override
    public void remove(Account x) {
        triggerRemove(x);
    }

    @Override
    public void modify(Account x) {
        triggerModify(x);
    }

    @Override
    public ArrayList<Account> getQuery(String query) {
        return null;
    }
}
