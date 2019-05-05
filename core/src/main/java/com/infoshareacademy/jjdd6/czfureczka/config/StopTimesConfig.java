package com.infoshareacademy.jjdd6.czfureczka.config;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class StopTimesConfig {

    private List<Timetable> stopTimes =new ArrayList<>();

    public List<Timetable> getStopTimes() {
        return stopTimes;
    }
    public void setStopTimes(List<Timetable> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public StopTimesConfig() { }

    public StopTimesConfig(List<Timetable> stopTimes) {
        this.stopTimes = stopTimes;
    }


    public void addStopTimesConfig(Timetable timetable) {
        this.stopTimes.add(timetable);
    }


}
