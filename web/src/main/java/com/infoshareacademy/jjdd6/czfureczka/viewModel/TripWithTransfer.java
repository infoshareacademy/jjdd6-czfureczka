package com.infoshareacademy.jjdd6.czfureczka.viewModel;

import java.util.List;
import java.util.Objects;

public class TripWithTransfer {

    private List<String> routeStart;
    private String stop;
    private List<String> routeEnd;

    public List<String> getRouteStart() {
        return routeStart;
    }

    public void setRouteStart(List<String> routeStart) {
        this.routeStart = routeStart;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public List<String> getRouteEnd() {
        return routeEnd;
    }

    public void setRouteEnd(List<String> routeEnd) {
        this.routeEnd = routeEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripWithTransfer that = (TripWithTransfer) o;
        return Objects.equals(routeStart, that.routeStart) &&
                Objects.equals(stop, that.stop) &&
                Objects.equals(routeEnd, that.routeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeStart, stop, routeEnd);
    }
}
