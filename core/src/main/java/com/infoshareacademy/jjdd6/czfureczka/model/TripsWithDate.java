package com.infoshareacademy.jjdd6.czfureczka.model;

import java.util.List;
//Lista tras

public class TripsWithDate {
    private String lastUpdate;
    private List<Trips> trips; //zawiera obiekty reprezentujące trasy (warianty)

    public String getLastUpdate() {
        return lastUpdate;
    }

    public List<Trips> getTrips() {
        return trips;
    }

}
