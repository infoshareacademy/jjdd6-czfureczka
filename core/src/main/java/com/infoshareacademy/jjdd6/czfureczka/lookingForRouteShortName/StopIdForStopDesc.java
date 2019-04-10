package com.infoshareacademy.jjdd6.czfureczka.lookingForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopsWithDate;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class StopIdForStopDesc {



    public List<Integer> stopIdForStopsDesc(String nazwa) {
        String s = Repository.getInstance().getStops().keySet().stream()
                .collect(Collectors.toList()).get(0);

        StopsWithDate stops = Repository.getInstance().getStops().get(s);
       // Stop stop = stops.getStops().get(0);

        List<Stop> newStops = stops.getStops();

        List<Integer> stopId = newStops.stream()
                .filter(s1 -> s1.getNonpassenger() == 0)
                .filter(l -> l.getStopDesc().equalsIgnoreCase(nazwa))
                .map(o -> o.getStopId())
                .collect(Collectors.toList());
        return stopId;

    }


}
