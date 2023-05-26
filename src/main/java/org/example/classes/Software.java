package org.example.classes;

public class Software {
    private int software_id;

    private int account_id;
    private String software_name;
    private int time_owned;
    private int software_type_id;

    public Software(int software_id){
        this.software_id = software_id;
    }

    public Software(int software_id, int account_id){
        this.software_id = software_id;
        this.account_id = account_id;
    }
    public Software(int software_id, int account_id, int software_type_id){
        this.software_id = software_id;
        this.account_id = account_id;
        this.software_type_id = software_type_id;
    }
    public Software(int software_id, int account_id, int software_type_id, String software_name){
        this.software_id = software_id;
        this.account_id = account_id;
        this.software_type_id = software_type_id;
        this.software_name = software_name;
    }
    public Software(int software_id, int account_id, int software_type_id, String software_name, int time_owned){
        this.software_id = software_id;
        this.account_id = account_id;
        this.software_type_id = software_type_id;
        this.software_name = software_name;
        this.time_owned = time_owned;
    }


    public int getSoftware_id() {
        return software_id;
    }

    public void setSoftware_id(int software_id) {
        this.software_id = software_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
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

    public void setTime_owned(int time_owned) {
        this.time_owned = time_owned;
    }

    public int getSoftware_type_id() {
        return software_type_id;
    }

    public void setSoftware_type_id(int software_type_id) {
        this.software_type_id = software_type_id;
    }
}
