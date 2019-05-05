package com.infoshareacademy.jjdd6.czfureczka.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DATA")
public class ExpeditionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "route_id")
    @NotNull
    private int routeId; //wewnętrzny identyfikator linii unikalny w skali Trójmiasta
    @Column(name = "trip_id")
    @NotNull
    private int tripId; //identyfikator wariantu/trasy, do której przynależy słupek. Wartość tripId z zasobu Lista tras
    @Column(name = "main_route")
    @NotNull
    private int mainRoute; //wartość określająca, czy wariant jest główny; 0 – nie, 1 – tak; bit

    public ExpeditionData() {
    }

    public ExpeditionData(@NotNull int routeId, @NotNull int tripId, @NotNull int mainRoute) {
        this.routeId = routeId;
        this.tripId = tripId;
        this.mainRoute = mainRoute;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public int getMainRoute() {
        return mainRoute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setMainRoute(int mainRoute) {
        this.mainRoute = mainRoute;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExpeditionData{");
        sb.append("id=").append(id);
        sb.append(", routeId=").append(routeId);
        sb.append(", tripId=").append(tripId);
        sb.append(", mainRoute=").append(mainRoute);
        sb.append('}');
        return sb.toString();
    }
}
