package com.infoshareacademy.jjdd6.czfureczka.model;

public class Route {
    private int routeId; //wewnętrzny identyfikator linii unikalny w skali Trójmiasta
    private int agencyId; //identyfikator floty, do której należy linia
    private String routeShortName; //numer linii używany m.in. na przystankach
    private String routeLongName; //opis linii najczęściej składający się z nazw przystanków krańcowych

    public int getRouteId() {
        return routeId;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }
}
