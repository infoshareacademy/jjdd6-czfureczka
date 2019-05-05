package com.infoshareacademy.jjdd6.czfureczka.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TRIP")
public class Trip {

    @Id
    @Column(name = "id", length = 25)
    @NotNull
    private String id; //identyfikator, tworzony według zasady „R” + routeId + „T” + tripId
    @Column(name = "route_id")
    @NotNull
    private int routeId; //identyfikator linii, do której przynależy wariant; wartość routeId z zasobu Lista linii;
    @Column(name = "trip_id")
    @NotNull
    private int tripId; //identyfikator wariantu unikalny w skali linii
    @Column(name = "trip_headsign")
    @NotNull
    private String tripHeadsign; //trasa, którą realizowany jest wariant. Najczęściej składa się z nazw przystanku początkowego i końcowego oraz ewentualnie z sugestią, na czym polega odstępstwo od wariantu głównego

    public Trip() {
    }

    public Trip(@NotNull String id, @NotNull int routeId, @NotNull int tripId, @NotNull String tripHeadsign) {
        this.id = id;
        this.routeId = routeId;
        this.tripId = tripId;
        this.tripHeadsign = tripHeadsign;
    }


    public String getId() {
        return id;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Trip{");
        sb.append("id='").append(id).append('\'');
        sb.append(", routeId=").append(routeId);
        sb.append(", tripId=").append(tripId);
        sb.append(", tripHeadsign='").append(tripHeadsign).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
