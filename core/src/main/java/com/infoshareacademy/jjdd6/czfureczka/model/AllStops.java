package com.infoshareacademy.jjdd6.czfureczka.model;

import com.infoshareacademy.jjdd6.czfureczka.lookingForRouteShortName.StopIdForStopDesc;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.List;

import java.util.stream.Collectors;

public class AllStops {
    public void run() {
        aaaa();

    }


    public void aaaa() {


        String k = Repository.getInstance().getStopsInTrip().keySet().stream()
                .collect(Collectors.toList()).get(0);

        StopsInTripWithDate stopsInTripWithDate = Repository.getInstance().getStopsInTrip().get(k);

        //  StopInTrip stopInTripTimes = stopsInTripWithDate.getStopsInTrip().get(0);

        List<StopInTrip> newStopInTrip = stopsInTripWithDate.getStopsInTrip();

        List<Integer> aaa = new StopIdForStopDesc().stopIdForStopsDesc("Budapesztańska");



            List<Integer> stopIdInTrip = newStopInTrip.stream()
                    .filter(s -> aaa.contains(s.getStopId()))
                    .map(s -> s.getRouteId())
                    .collect(Collectors.toList());

        }

    }



       /* String s = Repository.getInstance().stops.keySet().stream()
                .collect(Collectors.toList()).get(0);

        StopsWithDate stops = Repository.getInstance().stops.get(s);

        Stop stop1 = stops.getStops().get(0);

        List<Stop> newStops = stops.getStops();

        List<String> stopsDesc = newStops.stream()
                .filter(s1 -> s1.getNonpassenger() == 0)
                .filter()
                .collect(Collectors.toList());
        System.out.println(stopsDesc.get(1)); // Gdynia Kameliowa

        List<Integer> stopId = newStops.stream()
                .filter(s1 -> s1.getNonpassenger() == 0)
                .map(o -> o.getStopId())
                .collect(Collectors.toList());
        System.out.println(stopId.get(1)); // 8228


// Budapesztańska


        for (int i = 0; i < stopsDesc.size(); i++) {

            if ("Akademia Muzyczna".equals(stopsDesc.get(i))) {
                System.out.println(i); //953, 954,1346,1347
                System.out.println(stopId.get(i));// 1661, 1662, 2109, 2110
            }
        }
        System.out.println(stopId.get(953));

        String k = Repository.getInstance().stopsInTrip.keySet().stream()
                .collect(Collectors.toList()).get(0);

        StopsInTripWithDate stopsInTripWithDate = Repository.getInstance().stopsInTrip.get(k);

        StopInTrip stopInTripTimes= stopsInTripWithDate.getStopsInTrip().get(0);

        List<StopInTrip> newStopInTrip = stopsInTripWithDate.getStopsInTrip();

        List<Integer> stopIdInTrip = newStopInTrip.stream()
                .map(StopInTrip::getStopId)
                .collect(Collectors.toList());
        System.out.println(stopIdInTrip); //1380

        for (int i = 0; i < stopIdInTrip.size(); i++) {

           if (stopId.get(953).equals(stopIdInTrip.get(i))) {
               System.out.println("Afff");
               System.out.println(i); //2131
           }

        }
      //  List<StopInTrip>  aaa=newStopInTrip.stream()

   */


