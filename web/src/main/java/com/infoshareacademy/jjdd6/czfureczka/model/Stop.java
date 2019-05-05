package com.infoshareacademy.jjdd6.czfureczka.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "STOP")
public class Stop {

    @Id
    @Column(name = "stop_id")
    @NotNull
    private int stopId; //identyfikator słupka przystankowego unikalny w skali Trójmiasta

    @Column(name = "stop_desc")
    @NotNull
    private String stopDesc; //nazwa przystanku pochodząca z systemu TRISTAR

    @Column(name = "nonpassenger")
    @NotNull
    private int nonpassenger; // 1 = true => nie dla pasazera; sprawdzic mapowanie na boolean

    @OneToMany(mappedBy = "stop", fetch = FetchType.LAZY)
    private List<StopTimes> stopTimes;

    public Stop() {
    }

    public Stop(@NotNull int stopId, @NotNull String stopDesc, @NotNull int nonpassenger, List<StopTimes> stopTimes) {
        this.stopId = stopId;
        this.stopDesc = stopDesc;
        this.nonpassenger = nonpassenger;
        this.stopTimes = stopTimes;
    }

    public List<StopTimes> getStopTimes() {
        return stopTimes;
    }

    public void setStopTimes(List<StopTimes> stopTimes) {
        this.stopTimes = stopTimes;
    }


    public  int getStopId() {
        return stopId;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public int getNonpassenger() {
        return nonpassenger;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public void setNonpassenger(int nonpassenger) {
        this.nonpassenger = nonpassenger;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stop{");
        sb.append("stopId=").append(stopId);
        sb.append(", stopDesc='").append(stopDesc).append('\'');
        sb.append(", nonpassenger=").append(nonpassenger);
        sb.append(", stopTimes=").append(stopTimes);
        sb.append('}');
        return sb.toString();
    }
}
