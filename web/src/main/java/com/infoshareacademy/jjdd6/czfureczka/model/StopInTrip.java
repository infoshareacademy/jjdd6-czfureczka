package com.infoshareacademy.jjdd6.czfureczka.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STOP_IN_TRIP")
public class StopInTrip {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    @Column(name = "route_id")
    @NotNull
    private int routeId; //dentyfikator linii, do której przynależy słupek; wartość routeId z zasobu Lista linii
    @Column(name = "trip_id")
    @NotNull
    private int tripId; //identyfikator wariantu/trasy, do której przynależy słupek. Wartość tripId z zasobu Lista tras
    @Column(name = "stop_id")
    @NotNull
    private int stopId; //identyfikator słupka; wartość stopId z zasobu Lista przystanków
    @Column(name = "stop_sequence")
    @NotNull
    private int stopSequence;

    public StopInTrip() {
    }

    public StopInTrip(@NotNull int routeId, @NotNull int tripId, @NotNull int stopId, @NotNull int stopSequence) {
        this.routeId = routeId;
        this.tripId = tripId;
        this.stopId = stopId;
        this.stopSequence = stopSequence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStopSequence() {
        return stopSequence;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public void setStopSequence(int stopSequence) {
        this.stopSequence = stopSequence;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StopInTrip{");
        sb.append("id=").append(id);
        sb.append(", routeId=").append(routeId);
        sb.append(", tripId=").append(tripId);
        sb.append(", stopId=").append(stopId);
        sb.append(", stopSequence=").append(stopSequence);
        sb.append('}');
        return sb.toString();
    }
}
