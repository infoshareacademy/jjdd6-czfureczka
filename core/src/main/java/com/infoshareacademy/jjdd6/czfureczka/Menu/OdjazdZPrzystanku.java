package com.infoshareacademy.jjdd6.czfureczka.Menu;

import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.SearchForRouteShortName;

import java.util.List;
import java.util.Scanner;

public class OdjazdZPrzystanku {

    public boolean run() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Wpisz przystanek startowy: ");
        String start = scan.nextLine();
        SearchForRouteShortName searchForRouteShortName = new SearchForRouteShortName();
        List<String> stops = searchForRouteShortName.lookingForShortName(start);
        System.out.println("Przystanek " + start.toUpperCase() + " - dostepne polaczenia: ");
        System.out.println(String.join(", ", stops));

//        System.out.println("Wybierz polacznie: ");
//        Integer connection = scan.nextInt();
//        System.out.println("Najblizszy odjazd: ");

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
        if (option == 1) {
            return false;
        } else {
            return true;
        }

    }
}

