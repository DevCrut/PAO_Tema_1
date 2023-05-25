package org.example.classes;

public abstract class Software {
    int software_id;
    String software_name;
    int time_owned;

    public Software(int software_id){
        this.software_id = software_id;
    }
    public Software(int software_id, String software_name){
        this.software_id = software_id;
        this.software_name = software_name;
    }
    public Software(int software_id, String software_name, int time_owned){
        this.software_id = software_id;
        this.software_name = software_name;
        this.time_owned = time_owned;
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

    public int getTime_owned() {
        return time_owned;
    }

    public void setTime_owned(int time_created) {
        this.time_owned = time_created;
    }
}
