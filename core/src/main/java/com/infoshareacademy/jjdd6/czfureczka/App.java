package com.infoshareacademy.jjdd6.czfureczka;


import com.infoshareacademy.jjdd6.czfureczka.Menu.Menu;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.DepartureTimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
      //  Menu menu = new Menu();
    //   LocalDate today = LocalDate.now();
      //  LocalTime now = LocalTime.now();
     //   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

      //  menu.hello(today, now, dtf);
      //  menu.requestForPatience();

        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load("data")) {
            System.out.println("Data loaded");
        } else {
            System.err.println("Data could not be loaded");
            return;
        }

       // menu.run();

        DepartureTimes departureTimes=new DepartureTimes();
        departureTimes.departureTimes("Budapesztańska", "19:00:00");

    }
}
