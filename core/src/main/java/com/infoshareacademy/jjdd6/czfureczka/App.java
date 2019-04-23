package com.infoshareacademy.jjdd6.czfureczka;


import com.infoshareacademy.jjdd6.czfureczka.Menu.Menu;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Menu menu = new Menu();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        menu.hello(today, now, dtf);
        menu.requestForPatience();

        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load("data")) {
            logger.info("Data loaded");
        } else {
            logger.severe("Data could not be loaded");
            return;
        }

        menu.run();
    }
}
