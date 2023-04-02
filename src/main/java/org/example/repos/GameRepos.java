package org.example.repos;

import org.example.classes.Game;

import java.util.ArrayList;

public class GameRepos {
    ArrayList<Game> games;

    public void GameRepos(){
        this.games = new ArrayList<>();
    }
    public void GameRepos(ArrayList<Game> games){
        this.games = new ArrayList<>(games);
    }

    public void addGame(Game x){
        this.games.add(x);
    }

    public void removeGame(Game x){
        this.games.remove(x);
    }

    public void removeGame(String software_name){
        for(Game c : this.games)
            if (software_name.equals(c.getSoftware_name())) {
                this.removeGame(c);
                break;
            }
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
