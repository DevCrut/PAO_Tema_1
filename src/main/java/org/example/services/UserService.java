package org.example.services;

import org.example.classes.User;
import org.example.repos.UserRepos;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    static UserRepos repos;

    public UserService(){
        this.repos = new UserRepos();
    }

    public User addUser(Scanner s){
        System.out.println("Enter user id: ");
        int user_id = s.nextInt();

        System.out.println("Enter user name: ");
        String user_name = s.next();

        User user = new User(user_id, user_name);
        this.repos.addUser(user);

        return user;
    }

    public User modifyUser(User user, Scanner s){
        System.out.println("Enter user id: ");
        int user_id = s.nextInt();

        System.out.println("Enter user name: ");
        String user_name = s.next();

        user.setAccount_id(user_id);
        user.setAccount_name(user_name);
        return user;
    }

    public void removeUser(Scanner s)
    {
        System.out.println("Enter user name:");
        if(this.repos.removeUser(s.next()))
            System.out.println("User removed successfully!");
        else
            System.out.println("Error");
    }
}
