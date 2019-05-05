package com.infoshareacademy.jjdd6.czfureczka.viewModel;

import com.infoshareacademy.jjdd6.czfureczka.agency.ModeOfTransportation;

public class RouteWithModeOfTransportation implements Comparable<RouteWithModeOfTransportation>{

    private Integer routeId;
    private String routeShortName;
    private ModeOfTransportation modeOfTransportation;

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public ModeOfTransportation getModeOfTransportation() {
        return modeOfTransportation;
    }

    public void setModeOfTransportation(ModeOfTransportation modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }


    @Override
    public int compareTo(RouteWithModeOfTransportation o) {
        if (o.getRouteShortName().length() == this.getRouteShortName().length()){
            return this.routeShortName.compareTo(o.routeShortName);
        }else if (o.getRouteShortName().length() > this.getRouteShortName().length()){
            return -1;
        }else {
            return 1;
        }

    }

    public RouteWithModeOfTransportation(Integer routeId, String routeShortName, ModeOfTransportation modeOfTransportation) {
        this.routeId = routeId;
        this.routeShortName = routeShortName;
        this.modeOfTransportation = modeOfTransportation;
    }
}
