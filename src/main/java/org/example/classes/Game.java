package org.example.classes;

import org.example.enums.GameGenre;

public class Game extends Software{

    int size;
    GameGenre genre;

    public Game(int software_id) {
        super(software_id);
    }

    public Game(int software_id, String software_name) {
        super(software_id, software_name);
    }

    public Game(int software_id, String software_name, int time_created) {
        super(software_id, software_name, time_created);
    }

    public Game(int software_id, String software_name, int time_created, int software_sales) {
        super(software_id, software_name, time_created, software_sales);
    }

    public Game(int software_id, String software_name, int time_created, int software_sales, float software_rating) {
        super(software_id, software_name, time_created, software_sales, software_rating);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public GameGenre getGenre() {
        return genre;
    }

    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }
}
