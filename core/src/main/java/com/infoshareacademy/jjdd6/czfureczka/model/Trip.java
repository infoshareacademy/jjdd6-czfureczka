package com.infoshareacademy.jjdd6.czfureczka.model;

public class Trip {

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

}
