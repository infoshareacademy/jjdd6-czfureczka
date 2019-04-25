package com.infoshareacademy.jjdd6.czfureczka.Menu;

import com.infoshareacademy.jjdd6.czfureczka.departureTimes.DepartureTimes;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.SearchForRouteShortName;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DepartureFromStation {

    public boolean run() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Wpisz przystanek startowy: ");
        String start = scan.nextLine().trim();
        Validation validation = new Validation();
        while (!validation.validationOfStopName(start)) {
            System.out.println("Błędna nazwa przystanku!");
            System.out.println("Wpisz przystanek startowy: ");
            start = scan.nextLine().trim();
        }
        SearchForRouteShortName searchForRouteShortName = new SearchForRouteShortName();
        List<String> stops = searchForRouteShortName.lookingForShortName(start);
        System.out.println("Przystanek " + start.toUpperCase() + " - dostepne polaczenia: ");
        System.out.println(String.join(", ", stops));
        System.out.println("Rozkład");
        DepartureTimes departureTimes = new DepartureTimes();
        Map<String, List<String>> departure = departureTimes.departureTimes(start);
        System.out.println(Collections.singletonList(departure));

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("***************************** WYBIERZ OPCJE ************************************");
        System.out.println("*******   1. Powrót do menu ****************    2. Wyjście          ************");
        System.out.println("*****************************              *************************************");

        Menu menu = new Menu();
        Integer option = menu.run2();

        while (option != 1 && option != 2) {
            System.out.println("Wybrales zle, sprobuj ponownie");
            System.out.print("Twoj wybor: ");
            option = menu.run2();
        }
        return option != 1;

    }
}

