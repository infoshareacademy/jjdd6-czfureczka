package com.infoshareacademy.jjdd6.czfureczka.config;

import com.google.gson.annotations.Expose;

public class Timetable {

    @Expose
    private int routeId;
    @Expose
    private String file;

    public Timetable() {
    }

    public Timetable(int routeId, String file) {
        this.routeId = routeId;
        this.file = file;
    }
    public void setTimtable(int routeId, String file) {
        this.routeId = routeId;
        this.file=file;
    }
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getRouteId() {
        return routeId;
    }

    public String getFile() {
        return file;
    }
}
