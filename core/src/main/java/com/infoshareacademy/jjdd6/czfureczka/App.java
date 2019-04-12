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


import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args)  {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load()) {
            System.out.println("Data loaded");
        } else {
            System.err.println("Data could not be loaded");
            return;
        }




    }


}
