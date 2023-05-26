package org.example.services;

import org.example.classes.Software;

import java.util.ArrayList;

public interface Repos<T>{

    public void add(T x);

    public void remove(T s);

    public void modify(T x);

    public ArrayList<T> getQuery(String query);
}
