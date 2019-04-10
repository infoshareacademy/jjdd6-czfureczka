package com.infoshareacademy.jjdd6.czfureczka.Menu;

import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.SearchForRouteShortName;

import java.util.List;
import java.util.Scanner;

public class OdjazdZPrzystanku {

    public void run(){

        Scanner scan= new Scanner(System.in);

        System.out.println("Wpisz przystanek startowy: ");
        String start = scan.nextLine();
        SearchForRouteShortName searchForRouteShortName = new SearchForRouteShortName();
        List<String> stops = searchForRouteShortName.lookingForShortName(start);
        System.out.println("Przystanek "+ start + " - dostepne polaczenia: ");
        System.out.println(stops);

        System.out.println("Wybierz polacznie: ");
        Integer connection = scan.nextInt();

        System.out.println("Najblizszy odjazd: ");
    }
}

