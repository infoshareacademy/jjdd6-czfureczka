package com.infoshareacademy.jjdd6.czfureczka.model;

import java.util.List;

//Lista przystanków
public class StopsWithDate {
    private String lastUpdate;
    private List<Stop> stops; //zasób obiektów przetrzymujących informacje o słupkach przystankowych

    public String getLastUpdate() {
        return lastUpdate;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}

