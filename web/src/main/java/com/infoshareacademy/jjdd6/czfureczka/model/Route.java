package com.infoshareacademy.jjdd6.czfureczka.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "ROUTE")

public class Route {


    @Id
    @Column(name = "route_Id", length = 20)
    @NotNull
    private int routeId; //wewnętrzny identyfikator linii unikalny w skali Trójmiasta

    @Column(name = "route_short_name")
    @NotNull
    private String routeShortName; //numer linii używany m.in. na przystankach

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<StopTimes> stopTimes;

    public Route() {
    }

    public Route(@NotNull int routeId, @NotNull String routeShortName, List<StopTimes> stopTimes) {
        this.routeId = routeId;
        this.routeShortName = routeShortName;
        this.stopTimes = stopTimes;
    }

    public List<StopTimes> getStopTimes() {
        return stopTimes;
    }

    public void setStopTimes(List<StopTimes> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public int getRouteId() {
        return routeId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Route{");
        sb.append("routeId=").append(routeId);
        sb.append(", routeShortName='").append(routeShortName).append('\'');
        sb.append(", stopTimes=").append(stopTimes);
        sb.append('}');
        return sb.toString();
    }
}
