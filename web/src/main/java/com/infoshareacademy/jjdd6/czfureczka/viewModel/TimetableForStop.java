package com.infoshareacademy.jjdd6.czfureczka.viewModel;

import java.util.List;

public class TimetableForStop {

    private String routeId;
    private List<String> time;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

}
