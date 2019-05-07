package com.infoshareacademy.jjdd6.czfureczka.database;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "ROUTES")
public class RouteStatistic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    public RouteStatistic(){}

    public RouteStatistic(@NotNull String routeName, @NotNull LocalDate date) {
        this.name = routeName;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RouteStatistic{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
