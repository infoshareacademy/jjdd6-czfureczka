package com.infoshareacademy.jjdd6.czfureczka.model;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.awt.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AllStops {
    public void run() {
        String s = Repository.getInstance().stops.keySet().stream()
                .collect(Collectors.toList()).get(0);
        StopsWithDate stops = Repository.getInstance().stops.get(s);

        Stop stop1 = stops.getStops().get(0);

        List<Stop> newStops = stops.getStops();

        List<String> allStopsss=newStops.stream()
                .filter(s1 -> s1.getNonpassenger() == 0)
                .map(Stop::getStopDesc)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(allStopsss.get(0));



        List<Stop> stooooop=newStops.stream()
                .filter(s1 -> s1.getNonpassenger() == 0)
                .flatMap()


// Budapesztańska

        List<Integer> allStopsIds = newStops.stream()
                .filter(s1 -> s1.getNonpassenger() == 0)
                .map(o -> o.getStopId())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(allStopsIds);


       for (int i=0; i< allStopsss.size(); i++){

           if("Budapesztańska".equals(allStopsss.get(i))){
               System.out.println("aaa");

       }


      }
    }

}
