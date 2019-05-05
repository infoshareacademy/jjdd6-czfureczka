package com.infoshareacademy.jjdd6.czfureczka.viewModel;

import java.util.List;

public class TripWithStops {

    private Integer routeId;
    private Integer tripId;
    private String stopEnd;
    private List<String> stops;

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getStopEnd() {
        return stopEnd;
    }

    public void setStopEnd(String stopEnd) {
        this.stopEnd = stopEnd;
    }

    public List<String> getStops() {
        return stops;
    }

    public void setStops(List<String> stops) {
        this.stops = stops;
    }
}
