package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class StopIdForStopDesc {

    public List<Integer> stopIdForStopsDesc(String stopDesc) {
        List<Stop> newStops = Repository.getInstance().getStops();

        List<Integer> stopIds = newStops.stream()
                .filter(s1 -> s1.getNonpassenger() == 0)
                .filter(l -> l.getStopDesc().equals(stopDesc))
                .map(o -> o.getStopId())
                .collect(Collectors.toList());
        return stopIds;

    }


}
