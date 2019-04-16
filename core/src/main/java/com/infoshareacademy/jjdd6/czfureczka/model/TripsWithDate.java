package com.infoshareacademy.jjdd6.czfureczka.model;

import java.util.List;
//Lista tras

public class TripsWithDate {
    private String lastUpdate;
    private List<Trip> trips; //zawiera obiekty reprezentujące trasy (warianty)

    public String getLastUpdate() {
        return lastUpdate;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
