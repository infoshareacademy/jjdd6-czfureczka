package com.infoshareacademy.jjdd6.czfureczka;


import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.DepartureTime;

import java.sql.Time;
import java.util.List;


public class App {
    public static void main(String[] args) {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load()) {
            System.out.println("Data loaded");
        } else {
            System.err.println("Data could not be loaded");
            return;
        }

        DepartureTime departureTime=new DepartureTime();
        departureTime.departureTime("Budapesztańska","23:00:00");



    }


}
