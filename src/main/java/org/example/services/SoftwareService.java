package org.example.services;

import org.example.classes.App;
import org.example.classes.Game;
import org.example.classes.Software;
import org.example.enums.GameGenre;
import org.example.enums.MobileOS;
import org.example.repos.SoftwareRepos;
import org.example.repos.UserRepos;

import java.util.Scanner;

public class SoftwareService {

    SoftwareRepos repos;
    public SoftwareService(){
        repos = new SoftwareRepos();
    }

    public Software addSoftware(Scanner s){
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
            repos.addSoftware(newapp);

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
            repos.addSoftware(newgame);

            return newgame;
        }
    }

    public Game modifyGame(Game game, Scanner s){
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
        game.setSize(size);
        game.setGenre(gre);
        return game;
    }
    public App modifyApp(App app, Scanner s){
        System.out.println("Enter app os: [1 = IOS, 0 = ANDROID]");
        int os_type = s.nextInt();
        MobileOS os;
        if (os_type == 0){
            os = MobileOS.ANDROID;
        }else{
            os = MobileOS.IOS;
        }
        app.setDevice_type(os);
        return app;
    }


    public void removeSoftware(Scanner s)
    {
        System.out.println("Enter soft name:");
        if(this.repos.removeSoftware(s.next()))
            System.out.println("Soft removed successfully!");
        else
            System.out.println("Error");
    }

}
