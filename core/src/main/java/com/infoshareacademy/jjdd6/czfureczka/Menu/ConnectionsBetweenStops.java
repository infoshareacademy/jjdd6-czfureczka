package com.infoshareacademy.jjdd6.czfureczka.Menu;

import com.infoshareacademy.jjdd6.czfureczka.transfer.Transfer;
import com.infoshareacademy.jjdd6.czfureczka.directconnection.DirectConnection;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConnectionsBetweenStops {

    public boolean run() {
        Validation validation = new Validation();
        Scanner scan = new Scanner(System.in);

        System.out.println("Wpisz przystanek startowy: ");
        String start2 = scan.nextLine().trim();

        while (!validation.validationOfStopName(start2)) {
            System.out.println("Błędna nazwa przystanku!");
            System.out.println("Wpisz przystanek startowy: ");
            start2 = scan.nextLine().trim();
        }

        System.out.println("Wpisz przystanek docelowy: ");
        String destination = scan.nextLine().trim();
        while (!validation.validationOfStopName(destination)) {
            System.out.println("Błędna nazwa przystanku!");
            System.out.println("Wpisz przystanek docelowy: ");
            destination = scan.nextLine().trim();
        }

        System.out.println("Relacja " + start2.toUpperCase() + "-" + destination.toUpperCase());
        DirectConnection directConnection = new DirectConnection();
        List<String> trip = directConnection.checkSharedTrip(start2, destination);
        if (trip.size() == 0) {
            Transfer transfer = new Transfer();
            Map<Integer, List<String>> newTrip = transfer.transfer(start2, destination);
            if (newTrip.size() == 0) {
                System.out.println("Brak połączenia");
            } else {
                List<Integer> number = new ArrayList<>(newTrip.keySet());
                for (int i = 0; i < number.size(); i++) {
                    for (int j = 0; j < newTrip.get(number.get(i)).size(); j++) {
                        String word = newTrip.get(number.get(i)).get(j);
                        switch (word) {
                            case "przesiadka na:":
                            case "następnie pojedź:":
                                System.out.print(word + " ");
                                break;
                            case "Jesteś u celu!":
                                System.out.println("Jesteś u celu!");
                                System.out.println(" ");
                                break;
                            default:
                                System.out.print(word + ", ");
                        }
                    }
                }
            }
        } else {
            System.out.println("Dostepne polaczenia: ");
            System.out.println(String.join(", ", trip));

        }

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

        return option !=1;

    }
}
