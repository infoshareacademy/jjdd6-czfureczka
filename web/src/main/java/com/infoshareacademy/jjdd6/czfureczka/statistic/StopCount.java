package com.infoshareacademy.jjdd6.czfureczka.statistic;

import java.util.Objects;

public class StopCount implements Comparable<StopCount> {

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
        StopCount stopCount = (StopCount) o;
        return Objects.equals(name, stopCount.name) &&
                Objects.equals(quantity, stopCount.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }

    public StopCount(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(StopCount o) {
        return Integer.valueOf(o.getQuantity())-Integer.valueOf(this.getQuantity());
    }
}
