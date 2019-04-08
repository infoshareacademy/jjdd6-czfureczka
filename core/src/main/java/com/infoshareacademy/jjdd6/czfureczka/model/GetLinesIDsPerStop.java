package com.infoshareacademy.jjdd6.czfureczka.model;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

import java.util.List;
import java.util.stream.Collectors;

public class GetLinesIDsPerStop {

    private static void read() {

        RepositoryLoader repositoryLoader = new RepositoryLoader();

        if (repositoryLoader.load()) {
            System.out.println("ok");
    }
        else {}
    }


    // Przyjmuje słupekID, zwraca routeID, które przy nim stają

    public static List<Integer> getRoutesId (int slupekID) throws IllegalArgumentException {

        String someDate= Repository.getInstance().getStopsInTrip().keySet().stream().collect(Collectors.toList()).get(0);
        return Repository.getInstance().getStopsInTrip().get(someDate)
                .getStopsInTrip()
                .stream()
                .filter(a -> a.getStopId() == slupekID)
                .map(a -> a.getRouteId())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }




    public static void main(String[] args) {
        read();
        System.out.println(getRoutesId(2012));
    }



}
