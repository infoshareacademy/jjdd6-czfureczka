package com.infoshareacademy.jjdd6.czfureczka.database;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "STOPS")
public class StopStatistic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stopName")
    @NotNull
    private String stopName;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    private StopStatistic(){}

    public StopStatistic(@NotNull String stopName, @NotNull LocalDate date) {
        this.stopName = stopName;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StopStatistic{");
        sb.append("id=").append(id);
        sb.append(", stopName='").append(stopName).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
