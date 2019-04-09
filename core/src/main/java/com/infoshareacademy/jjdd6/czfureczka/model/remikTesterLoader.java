package com.infoshareacademy.jjdd6.czfureczka.model;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;
import static com.infoshareacademy.jjdd6.czfureczka.model.SearchDirectConnection.*;


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
        //System.out.println(GetRouteNameFromID(6));
        //System.out.println(getRoutesIdForStop(  1252));
        //GetRoutesNamesFromIDs(getRoutesIdForStop(1252)).stream().forEach(a-> System.out.println(a));
        //System.out.println(isRouteIdStoppingAtStopId(402, 1252));
        System.out.println(GetRoutesNamesFromIDs(findDirectConnection(2038, 2095)));


    }


}
