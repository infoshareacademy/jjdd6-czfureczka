package com.infoshareacademy.jjdd6.czfureczka.model;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.awt.*;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AllStops {
    public void run() {
        String s = Repository.getInstance().stops.keySet().stream()
                .collect(Collectors.toList()).get(0);
        StopsWithDate stops = Repository.getInstance().stops.get(s);

      /*  List<Stop> newStops = stops.getStops();
        newStops.stream()
                .filter(s1->s1.getNonpassenger()==0)
                .map(Stop::getStopDesc)
                .distinct()
                .sorted()
                .forEach(System.out::println);
       */
        List<Stop> newStopId=stops.getStops();
        newStopId.stream()
                .filter(s1->s1.getNonpassenger()==0)
                .map(Stop::getStopId)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("-----------------------------");


    }

}
