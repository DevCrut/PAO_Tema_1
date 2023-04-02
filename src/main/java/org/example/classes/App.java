package org.example.classes;

import org.example.enums.MobileOS;

public class App extends Software {

    MobileOS device_type;

    public App(int software_id) {
        super(software_id);
    }

    public App(int software_id, String software_name) {
        super(software_id, software_name);
    }

    public App(int software_id, String software_name, int time_created) {
        super(software_id, software_name, time_created);
    }

    public App(int software_id, String software_name, int time_created, int software_sales) {
        super(software_id, software_name, time_created, software_sales);
    }

    public App(int software_id, String software_name, int time_created, int software_sales, float software_rating) {
        super(software_id, software_name, time_created, software_sales, software_rating);
    }

    public MobileOS getDevice_type() {
        return device_type;
    }

    public void setDevice_type(MobileOS device_type) {
        this.device_type = device_type;
    }
}
