package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.config.StopTimesConfig;
import com.infoshareacademy.jjdd6.czfureczka.config.Timetable;
import com.infoshareacademy.jjdd6.czfureczka.model.*;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureTime {

    public List<String> departureTime(String stopDesc, String departurTime) {

        List<Integer> data = Repository.getInstance().getStopTimes().keySet().stream()
                .collect(Collectors.toList());

        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();

        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc(stopDesc);
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        List<Integer> routShortNames = data.stream()
                .filter(routeIds::contains)
                .collect(Collectors.toList());
     //   routShortNames.forEach(System.out::println);  //130,12

        List<String> al = new ArrayList<>();

        for (int i = 0; i < routShortNames.size(); i++) {
            StopTimesWithDate stops = Repository.getInstance().getStopTimes().get(routShortNames.get(i));

            List<StopTimes> news = stops.getStopTimes();

            List<String> firstTime = news.stream()
                    .filter(s -> stopIds.contains(s.getStopId()))
                    .map(StopTimes::getDepartureTime)
                    .collect(Collectors.toList());

            List<String> kot = firstTime.stream()
                    .map(s -> s.split("T"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());

            List<String> kot2 = kot.stream()
                    .filter(s -> !s.contains("1899-12-30"))
                    .sorted()
                    .collect(Collectors.toList());

            List<Time> listaTime = kot2.stream()
                    .map(Time::valueOf)
                    .collect(Collectors.toList());

            Time timmmm = Time.valueOf(departurTime);

            List<String> listOfDeparture = listaTime.stream()
                    .filter(s -> s.after(timmmm))
                    .limit(5)
                    .map(m -> m.toString())
                    .collect(Collectors.toList());


            if(listOfDeparture.size()<5){

                Time timmmm2 = Time.valueOf("00:00:00");

                List<String> listOfDeparture2 = listaTime.stream()
                        .filter(s -> s.after(timmmm2))
                        .limit(5-listOfDeparture.size())
                        .map(m -> m.toString())
                        .collect(Collectors.toList());

                listOfDeparture.addAll(listOfDeparture2);

            }


            String dodawac="1899-12-30T";

            List<String> dziwneGodziny=listOfDeparture.stream()
                    .map(s->dodawac+s)
                    .collect(Collectors.toList());

            List<Integer> routeId = news.stream()
                    .filter(s -> stopIds.contains(s.getStopId()) && dziwneGodziny.contains(s.getDepartureTime()))
                    .map(StopTimes::getTripId)
                    .collect(Collectors.toList());


            String data2 = Repository.getInstance().getStops().keySet().stream()
                    .collect(Collectors.toList()).get(0);

            TripsWithDate tripsWithDate = Repository.getInstance().getTrips().get(data2);

            List<Trip> newTrip = tripsWithDate.getTrips();

            List<String> stopIdss = newTrip.stream()
                    .filter(l -> routeId.contains(l.getRouteId()))
                    .map(o -> o.getTripHeadsign())
                    .collect(Collectors.toList());
            stopIdss.forEach(System.out::println);



            al.addAll(listOfDeparture);

            System.out.println("5 najbliższych odjazdów nr " + routShortNames.get(i));
            listOfDeparture.forEach(System.out::println);


        }

        return al;
    }
}