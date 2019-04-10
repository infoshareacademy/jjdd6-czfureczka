package com.infoshareacademy.jjdd6.czfureczka.view;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;
import static com.infoshareacademy.jjdd6.czfureczka.view.SearchDirectConnection.*;
import com.infoshareacademy.jjdd6.czfureczka.lookingForRouteShortName.*;

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

        StopIdForStopDesc sID = new StopIdForStopDesc();
        //System.out.println(sID.stopIdForStopsDesc("Łostowice Świętokrzyska"));
        //System.out.println(GetRouteNameFromID(6));
        //System.out.println(getRoutesIdForStop(  1252));
        //GetRoutesNamesFromIDs(getRoutesIdForStop(1252)).stream().forEach(a-> System.out.println(a));
        //System.out.println(isRouteIdStoppingAtStopId(402, 1252));
        GetRoutesNamesFromIDs(findDirectConnection((sID.stopIdForStopsDesc("Akademia Muzyczna")),(sID.stopIdForStopsDesc("Dworzec Główny")))).stream().forEach(a-> System.out.println(a));

    }
}
