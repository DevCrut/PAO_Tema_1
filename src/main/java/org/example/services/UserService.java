package org.example.services;

import org.example.classes.App;
import org.example.classes.Game;
import org.example.classes.Software;
import org.example.classes.User;
import org.example.classes.Wallet;
import org.example.enums.GameGenre;
import org.example.enums.MobileOS;
import org.example.repos.UserRepos;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    UserRepos repos;

    public void UserService(){
        repos = new UserRepos();
    }

    public void addUser(Scanner s){
        System.out.println("Enter user id: ");
        int user_id = s.nextInt();

        System.out.println("Enter user name: ");
        String user_name = s.next();

        User user = new User(user_id, user_name);

        System.out.println("Generating Wallet");
        user.setWallet(this.createWallet(s));

        System.out.println("Enter user Software count: ");
        int count = s.nextInt();
        ArrayList<Software> softs = new ArrayList<>();
        for (int i = 0; i < count; i++){
            Software soft = this.createSoftware(s);
            softs.add(soft);
        }
        user.setOwnedItems(softs);
        this.repos.addUser(user);
    }

    public Software createSoftware(Scanner s){
        System.out.println("Enter software id: ");
        int software_id = s.nextInt();

        System.out.println("Enter software name: ");
        String software_name = s.next();

        System.out.println("Enter software time created: ");
        int software_time_created = s.nextInt();

        System.out.println("Enter software sales: ");
        int software_sales = s.nextInt();

        System.out.println("Enter software rating: ");
        float software_rating = s.nextFloat();

        System.out.println("Enter software type: [1 = Game, 0 = App]");
        int type = s.nextInt();
        if (type == 0){
            System.out.println("Enter app os: [1 = IOS, 0 = ANDROID]");
            int os_type = s.nextInt();
            MobileOS os;
            if (os_type == 0){
                os = MobileOS.ANDROID;
            }else{
                os = MobileOS.IOS;
            }
            App newapp = new App(software_id, software_name, software_time_created, software_sales, software_rating);
            newapp.setDevice_type(os);
            return newapp;
        }else{
            System.out.println("Enter size in MB: ");
            int size = s.nextInt();
            System.out.println("Enter app os:   [5 = SHOOTER,\n" +
                    "    4 = BUILDING,\n" +
                    "    3 = PUZZLE,\n" +
                    "    2 = INDIE,\n" +
                    "    1 = STORY,\n" +
                    "    0 = OTHER]");
            int genre_type = s.nextInt();
            GameGenre gre;
            switch (genre_type){
                case 1:
                    gre = GameGenre.STORY;
                    break;
                case 2:
                    gre = GameGenre.INDIE;
                    break;
                case 3:
                    gre = GameGenre.PUZZLE;
                    break;
                case 4:
                    gre = GameGenre.BUILDING;
                    break;
                case 5:
                    gre = GameGenre.SHOOTER;
                    break;
                default:
                    gre = GameGenre.OTHER;
            }
            Game newgame = new Game(software_id, software_name, software_time_created, software_sales, software_rating);
            newgame.setGenre(gre);
            newgame.setSize(size);
            return newgame;
        }
    }

    public Wallet createWallet(Scanner s){
        System.out.println("Enter bonus points: ");
        int bonus_points = s.nextInt();

        System.out.println("Enter dollars: ");
        int dollars = s.nextInt();
        return new Wallet(bonus_points, dollars);
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
