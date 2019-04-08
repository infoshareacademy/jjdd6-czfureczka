/*
Pobieranie danych o trasach
 */
/*
package com.infoshareacademy.jjdd6.czfureczka.model;

import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopsWithDate;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AllTrips {

        private List riseTripsList () {

            RepositoryLoader repositoryLoader = new RepositoryLoader();

            if (repositoryLoader.load()) {
                String privateTrips = Repository.getInstance().getTrips().keySet().stream().collect(Collectors.toList()).get(0);
                TripsWithDate trips = Repository.getInstance().getTrips().get(privateTrips);
                List<Trip> newTrips = trips.getTrips();
                return newTrips;
            }
            else return null;
        }


        public String getRouteId (int slupekiD) throws IllegalArgumentException {

            List<Trip> stopList = riseTripsList();
            for (Trip trip : stopList) {
                if (trip.)

            }



        }


    public static void main(String[] args) {
        getRouteId(1120);
    }


}
*/