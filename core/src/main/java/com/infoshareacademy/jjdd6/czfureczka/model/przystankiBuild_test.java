package com.infoshareacademy.jjdd6.czfureczka.model;

import java.util.List;
import static com.infoshareacademy.jjdd6.czfureczka.model.BuildStopsObjectArray.*;


public class przystankiBuild_test {


    public static void main(String[] args) {

        List<Stop> PRZYSTANKI = buildStopsArrayList();
        PRZYSTANKI.forEach(o -> System.out.println(o.getStopName()+","+o.getStopId()+","+o.getStopDesc()+", "+o.getStopShortName()));
    }
}
