/*
Pobieranie danych o trasach
 */

package com.infoshareacademy.jjdd6.czfureczka.model;

import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopsWithDate;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AllTrips {

    public static void main(String[] args) {
        run();
    }

        public static void run() {

            RepositoryLoader repositoryLoader = new RepositoryLoader();
            if (repositoryLoader.load()) {
                String s = Repository.getInstance().trips.keySet().stream().collect(Collectors.toList()).get(0);
                TripsWithDate trips = Repository.getInstance().trips.get(s);
                List<Trip> newTrips = trips.getTrips();
                for (Trip newTrip : newTrips) {
                    System.out.println(newTrip.getTripHeadsign()+" "+newTrip.getRouteId());
                }
            }



        }
}