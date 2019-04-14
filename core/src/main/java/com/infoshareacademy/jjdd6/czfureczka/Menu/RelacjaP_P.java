package com.infoshareacademy.jjdd6.czfureczka.Menu;

import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.SearchForRouteShortName;

import java.util.List;
import java.util.Scanner;

public class RelacjaP_P {

    public void run()

    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Wpisz przystanek startowy: ");
        String start2 = scan.nextLine();

        System.out.println("Wpisz przystanek docelowy: ");
        String destination = scan.nextLine();

        System.out.println("Relacja " + start2.toUpperCase() + "-" + destination.toUpperCase());
        SearchForRouteShortName searchForRouteShortName = new SearchForRouteShortName();
        List<String> stops = searchForRouteShortName.lookingForShortName(start2);
        System.out.println("Dostepne polaczenia: ");
        System.out.println(stops);

        System.out.print("Wybierz polaczenie: ");
        Integer connnection2 = scan.nextInt();

        System.out.println("Najblizszy odjazd: ");

    }


}
