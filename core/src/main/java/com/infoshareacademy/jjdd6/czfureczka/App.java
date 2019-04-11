package com.infoshareacademy.jjdd6.czfureczka;


import com.infoshareacademy.jjdd6.czfureczka.config.StopTimesConfig;
import com.infoshareacademy.jjdd6.czfureczka.config.Timetable;
import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopTimes;
import com.infoshareacademy.jjdd6.czfureczka.model.StopTimesWithDate;
import com.infoshareacademy.jjdd6.czfureczka.model.StopsWithDate;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteIdForStopId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.StopIdForStopDesc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load()) {
            System.out.println("Data loaded");
        } else {
            System.err.println("Data could not be loaded");
            return;
        }

        List<Integer> data = Repository.getInstance().getStopTimes().keySet().stream()
                .collect(Collectors.toList());
        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();
        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc("Budapesztańska");

        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        //  neww.forEach(System.out::println);

        //Stream.of(data,neww).filter(s,b)->neww.contains(data)).forEach(System.out::println);

      //  data.retainAll(neww);
     //   System.out.println(data);

        List<Integer> routShortNames = data.stream()
                .filter(routeIds::contains)
                .collect(Collectors.toList());
        routShortNames.forEach(System.out::println);  //2,12

        System.out.println("ogorekiiiiiiiiiiiiii");
        StopTimesWithDate stops = Repository.getInstance().getStopTimes().get(routShortNames.get(0));


        List<StopTimes> news = stops.getStopTimes();


        //  news.forEach(System.out::println);
        news.stream()
                .map(d -> d.getRouteId())
                .collect(Collectors.toList())
                .forEach(System.out::println);

   /*     StopTimesConfig zz=Repository.getInstance();

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
 */

    }


}
