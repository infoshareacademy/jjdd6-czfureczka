package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.StopTimes;
import com.infoshareacademy.jjdd6.czfureczka.model.StopTimesWithDate;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureTime {}


  /*  public List<String> departureTime(String stopDesc,  ){
        List<Integer> data = Repository.getInstance().getStopTimes().keySet().stream()
                .collect(Collectors.toList());
        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();
        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc("Budapesztańska");
        stopIds.forEach(System.out::println);
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);


        List<Integer> routShortNames = data.stream()
                .filter(routeIds::contains)
                .collect(Collectors.toList());
        routShortNames.forEach(System.out::println);  //130,12


        StopTimesWithDate stops = Repository.getInstance().getStopTimes().get(routShortNames.get(0));


        List<StopTimes> news = stops.getStopTimes();

        List<String> firstTime=news.stream()
                .filter(s->stopIds.contains(s.getStopId()))
                .map(StopTimes::getDepartureTime)
                .collect(Collectors.toList());
        // firstTime.forEach(System.out::println);

        List<String> kot=firstTime.stream()
                .map(s->s.split("T"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        //kot.forEach(System.out::println);

        kot.stream()
                .filter(s-> !s.contains("1899-12-30"))
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);


       StopTimesConfig zz=Repository.getInstance();

        List<Timetable> list = stopTimesConfig.getStopTimes();


        List<String> zz=stops.s
                .filter(a->routShortNames)

        StopsWithDate stops = Repository.getInstance().getStops().get(data);
        List<Stop> newStops = stops.getStops();
        List<Integer> stopIds = newStops.stream()
                .filter(s1 -> s1.getNonpassenger() == 0)
                .filter(l -> l.getStopDesc().equalsIgnoreCase(stopDesc))
                .map(o -> o.getStopId())
               .collect(Collectors.toList());


    }
}

  */