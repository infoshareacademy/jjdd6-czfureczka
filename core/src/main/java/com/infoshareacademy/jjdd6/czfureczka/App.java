package com.infoshareacademy.jjdd6.czfureczka;


import com.infoshareacademy.jjdd6.czfureczka.lookingForRouteShortName.RouteIdForStopId;
import com.infoshareacademy.jjdd6.czfureczka.lookingForRouteShortName.RouteShortIdForRouteId;
import com.infoshareacademy.jjdd6.czfureczka.lookingForRouteShortName.StopIdForStopDesc;
import com.infoshareacademy.jjdd6.czfureczka.model.AllStops;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

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

        // AllStops allStops = new AllStops();
        //  allStops.run();

        //  StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        // stopIdForStopDesc.stopIdForStopsDesc("Budapesztańska");

    }


}
