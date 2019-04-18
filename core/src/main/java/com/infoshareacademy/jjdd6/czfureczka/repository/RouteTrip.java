package com.infoshareacademy.jjdd6.czfureczka.repository;

import java.util.Objects;

public class RouteTrip {

    private int routeID;
    private int tripID;

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public RouteTrip(int routeID, int tripID) {
        this.routeID = routeID;
        this.tripID = tripID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteTrip routeTrip = (RouteTrip) o;
        return routeID == routeTrip.routeID &&
                tripID == routeTrip.tripID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeID, tripID);
    }
}
