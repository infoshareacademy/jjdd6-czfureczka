package com.infoshareacademy.jjdd6.czfureczka.model;


import java.util.List;


public class StopTimesWithDate {

    private String lastUpdate;
    private List<StopTimes> stopTimes; //zasób z informacjami o zdefiniowanym rozkładzie jazdy

    public String getLastUpdate() {
        return lastUpdate;
    }

    public List<StopTimes> getStopTimes() {
        return stopTimes;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setStopTimes(List<StopTimes> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public StopTimesWithDate() {
    }

    public StopTimesWithDate(String lastUpdate, List<StopTimes> stopTimes) {
        this.lastUpdate = lastUpdate;
        this.stopTimes = stopTimes;
    }
}
