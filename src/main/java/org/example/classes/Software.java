package org.example.classes;

public class Software {
    int software_id;
    String software_name;
    int time_created;
    int software_sales;
    float software_rating;

    public Software(int software_id){
        this.software_id = software_id;
    }
    public Software(int software_id, String software_name){
        this.software_id = software_id;
        this.software_name = software_name;
    }
    public Software(int software_id, String software_name, int time_created){
        this.software_id = software_id;
        this.software_name = software_name;
        this.time_created = time_created;
    }
    public Software(int software_id, String software_name, int time_created, int software_sales){
        this.software_id = software_id;
        this.software_name = software_name;
        this.time_created = time_created;
        this.software_sales = software_sales;
    }
    public Software(int software_id, String software_name, int time_created, int software_sales, float software_rating){
        this.software_id = software_id;
        this.software_name = software_name;
        this.time_created = time_created;
        this.software_sales = software_sales;
        this.software_rating = software_rating;
    }

    public int getSoftware_id() {
        return software_id;
    }

    public void setSoftware_id(int software_id) {
        this.software_id = software_id;
    }

    public String getSoftware_name() {
        return software_name;
    }

    public void setSoftware_name(String software_name) {
        this.software_name = software_name;
    }

    public int getTime_created() {
        return time_created;
    }

    public void setTime_created(int time_created) {
        this.time_created = time_created;
    }

    public int getSoftware_sales() {
        return software_sales;
    }

    public void setSoftware_sales(int software_sales) {
        this.software_sales = software_sales;
    }

    public float getSoftware_rating() {
        return software_rating;
    }

    public void setSoftware_rating(float software_rating) {
        this.software_rating = software_rating;
    }
}
