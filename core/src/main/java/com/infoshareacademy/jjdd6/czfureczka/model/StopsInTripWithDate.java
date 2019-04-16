package com.infoshareacademy.jjdd6.czfureczka.model;

import java.util.List;

//Przystanki w powiązaniu z trasą
public class StopsInTripWithDate {
    private String lastUpdate;
    private List<StopInTrip> stopsInTrip; //zawiera obiekty reprezentujące słupki i ich przyporządkowanie do wariantów w liniach oraz pozycję w wariancie

    public String getLastUpdate() {
        return lastUpdate;
    }

    public List<StopInTrip> getStopsInTrip() {
        return stopsInTrip;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setStopsInTrip(List<StopInTrip> stopsInTrip) {
        this.stopsInTrip = stopsInTrip;
    }
}
