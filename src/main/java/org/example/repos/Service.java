package org.example.repos;

import java.util.ArrayList;

public interface Service<T> {
    public void add(T x);
    public void addMany(ArrayList<T> x);
    public void remove(T x);
    public void removeMany(ArrayList<T> x);
    public void modify(T x);
    public void modifyMany(ArrayList<T> x);
}
