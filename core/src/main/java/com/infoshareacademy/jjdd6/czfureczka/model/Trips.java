package com.infoshareacademy.jjdd6.czfureczka.model;


public class Trips {

    private String id; //identyfikator, tworzony według zasady „R” + routeId + „T” + tripId
    private int routeId; //identyfikator linii, do której przynależy wariant; wartość routeId z zasobu Lista linii;
    private int tripId; //identyfikator wariantu unikalny w skali linii
    private String tripHeadsign; //trasa, którą realizowany jest wariant. Najczęściej składa się z nazw przystanku początkowego i końcowego oraz ewentualnie z sugestią, na czym polega odstępstwo od wariantu głównego
    private int directionId; //kierunek wariantu. Wartość 1 – „tam”, wartość 2: „powrót”

    public String getId() {
        return id;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public int getDirectionId() {
        return directionId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }
}
