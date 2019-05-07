package com.infoshareacademy.jjdd6.czfureczka.statistic;

import java.util.Objects;

public class RouteCount implements Comparable<RouteCount> {

    private String name;
    private String quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteCount RouteCount = (RouteCount) o;
        return Objects.equals(name, RouteCount.name) &&
                Objects.equals(quantity, RouteCount.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }

    public RouteCount(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(RouteCount o) {
        return Integer.valueOf(o.getQuantity())-Integer.valueOf(this.getQuantity());
    }
}
