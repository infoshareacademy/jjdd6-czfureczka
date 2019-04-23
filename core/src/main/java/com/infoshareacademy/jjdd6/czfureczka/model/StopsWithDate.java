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

}

