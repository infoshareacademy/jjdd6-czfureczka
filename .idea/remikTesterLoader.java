package com.infoshareacademy.jjdd6.czfureczka.SearchConnection;
import com.infoshareacademy.jjdd6.czfureczka.SearchConnection.SearchConnection;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;
import com.infoshareacademy.jjdd6.czfureczka.SearchConnection.SearchConnection.*;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.*;

import java.util.List;


public class remikTesterLoader {

    public static void loadRepo() {

        RepositoryLoader repositoryLoader = new RepositoryLoader();

        if (repositoryLoader.load()) {
            System.out.println("ok");
        }
        else {}
    }


    public static void main(String[] args) {

        remikTesterLoader.loadRepo();

        SearchConnection searchConnection = new SearchConnection();

        StopIdForStopDesc sID = new StopIdForStopDesc();
        //System.out.println(sID.stopIdForStopsDesc("Łostowice Świętokrzyska"));
        //System.out.println(GetRouteNameFromID(6));
        //System.out.println(getRoutesIdForStop(  1252));
        //GetRoutesNamesFromIDs(getRoutesIdForStop(1252)).stream().forEach(a-> System.out.println(a));
        //System.out.println(isRouteIdStoppingAtStopId(402, 1252));
        searchConnection
                .getRoutesNamesFromIDs(searchConnection
                        .findDirectConnection(
                                (sID.stopIdForStopsDesc("Łostowice świętokrzyska")),(sID.stopIdForStopsDesc("Dworzec Główny"))))
                .stream().forEach(a-> System.out.println(a));

    }
}