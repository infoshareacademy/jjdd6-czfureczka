package com.infoshareacademy.jjdd6.czfureczka.model;

public class ExpeditionData {

    private int routeId; //wewnętrzny identyfikator linii unikalny w skali Trójmiasta
    private int tripId; //identyfikator wariantu/trasy, do której przynależy słupek. Wartość tripId z zasobu Lista tras
    private int mainRoute; //wartość określająca, czy wariant jest główny; 0 – nie, 1 – tak; bit

    public int getRouteId() {
        return routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public int getMainRoute() {
        return mainRoute;
    }
}
