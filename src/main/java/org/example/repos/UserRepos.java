package org.example.repos;

import org.example.classes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;

public class UserRepos {
    ArrayList<User> users;

    public void UserRepos(){
        this.users = new ArrayList<>();
    }
    public void UserRepos(ArrayList<User> users){
        this.users = new ArrayList<>(users);
    }

    public void addUser(User x){
        this.users.add(x);
    }

    public void removeUser(User x){
        this.users.remove(x);
    }

    public boolean removeUser(String account_name){
        for(User c : this.users)
            if (account_name.equals(c.getAccount_name())) {
                this.removeUser(c);
                return true;
            }
        return false;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
