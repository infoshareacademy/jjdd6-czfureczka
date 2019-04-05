package com.infoshareacademy.jjdd6.czfureczka.model;

import java.util.List;

//Lista linii
public class RoutesWithDate {
    private String lastUpdate;
    private List<Route> routes; //zasób obiektów przetrzymujących informacje o liniach

    public String getLastUpdate() {
        return lastUpdate;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
