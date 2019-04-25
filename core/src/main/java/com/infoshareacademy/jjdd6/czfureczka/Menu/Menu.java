package com.infoshareacademy.jjdd6.czfureczka.Menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Menu {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    public void run() {

        boolean loop = false;
        while (!loop) {
            for (int i = 0; i < 10; i++) {
                System.out.println(" ");
            }

            LocalDate today = LocalDate.now();
            LocalTime now = LocalTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

            hello(today, now, dtf);

            System.out.println("***************************** WYBIERZ OPCJE ************************************");
            System.out.println("*   1. Odjazd z przystanku. **************** 2. Relacja przystanek-przystanek. *");
            System.out.println("*****************************              *************************************");
            System.out.println("*                3. Odjazd z przystanku o danej godzinie.                      *");
            System.out.println(" ");
            System.out.println("****************************** 4. Wyjście **************************************");
            System.out.println(" ");
            System.out.print("                               WPISZ NUMER: ");

            Integer option = run2();
            logger.fine("Selected option: " + option);

            while (option != 1 && option != 2 && option != 3 && option != 4) {
                System.out.println("Wybrałeś źle, spróbuj ponownie");
                System.out.print("Twoj wybor: ");
                option = run2();
                logger.fine("Selected option: " + option);
            }
            switch (option) {
                case 1:
                    DepartureFromStation odjazd = new DepartureFromStation();
                    loop = odjazd.run();
                    break;
                case 2:
                    ConnectionsBetweenStops relacja = new ConnectionsBetweenStops();
                    loop = relacja.run();
                    break;
                case 3:
                    DepartureFromStationOnTime times = new DepartureFromStationOnTime();
                    loop = times.run();
                case 4:
                    loop = true;
                    break;
            }
        }
    }

    public void hello(LocalDate today, LocalTime now, DateTimeFormatter dtf) {
        System.out.println(" ____________________________________________________________________________");
        System.out.println("|                                                                            |");
        System.out.println("|                       Witaj w aplikacji 'Szybko do Celu'!                  |");
        System.out.println("|                      Dzisiaj na pewno dojedziesz na czas :)                |");
        System.out.println("|                               Data: " + today + "                             |");
        System.out.println("|                               Godzina: " + " " + now.format(dtf) + "                              |");
        System.out.println("|____________________________________________________________________________|");
        System.out.println(" ");
        System.out.println(" ");
    }

    public Integer run2() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine().trim();
        logger.info("Selected option before validation: " + option);
        List<String> cyferki = new ArrayList<>();
        cyferki.add("0");
        cyferki.add("1");
        cyferki.add("2");
        cyferki.add("3");
        cyferki.add("4");
        cyferki.add("5");
        cyferki.add("6");
        cyferki.add("7");
        cyferki.add("8");
        cyferki.add("9");
        String[] zamiana = option.split("");
        List<String> test1 = Arrays.stream(zamiana)
                .filter(cyferki::contains)
                .collect(Collectors.toList());
        if (zamiana.length == test1.size()) {
            return Integer.valueOf(option);
        }
        return 9999;
    }

    public void requestForPatience() {

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("****************************** Proszę czekać ***********************************");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("****************************** Ładuję dane *************************************");
        System.out.println(" ");
        System.out.println(" ");
    }
}
