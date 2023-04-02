package org.example.repos;

import org.example.classes.Software;

import java.util.ArrayList;

public class SoftwareRepos {
    ArrayList<Software> softs;

    public SoftwareRepos(){
        this.softs = new ArrayList<>();
    }
    public SoftwareRepos(ArrayList<Software> softs){
        this.softs = new ArrayList<>(softs);
    }

    public void addSoftware(Software x){
        this.softs.add(x);
    }

    public void removeSoftware(Software x){
        this.softs.remove(x);
    }

    public boolean removeSoftware(String software_name){
        for(Software c : this.softs)
            if (software_name.equals(c.getSoftware_name())) {
                this.removeSoftware(c);
                return true;
            }
        return false;
    }

    public ArrayList<Software> getSoftwares() {
        return softs;
    }
}
